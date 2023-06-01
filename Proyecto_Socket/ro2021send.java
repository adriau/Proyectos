import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class ro2021send {
    public static void main(String[] args) {
        //Variables paramentros
        String nombreArchivo;
        String ipServidor;
        short puertoServidor;
        String ipSR;
        int puertoSR;

        //Variables
        int ack = 0; //ack de los paquetes
        int ce = 0;  //ce sera como ackAux y para saber si se acabo de recorrer el array de bytes con los datos del fichero
        int recorrer = 0; //variable para recorrer el array de bytes con los datos del fichero
        ByteArrayOutputStream buffer = null; //Creamos buffer
        FileInputStream archivo;  //Abrimos fichero
        byte[] datos;  //Array de bytes que contendra los datos del fichero
        DatagramSocket socket;  //Creamos el socket
        DatagramPacket paqueteEnv;  //Creamos el paquete que enviaremos
        DatagramPacket paqueteRecv;  //Creamos el paquete que recibiremos
        byte ackArray[];  //Creamos un array para los datos del ACK del paquete recibido

        if (args.length == 5) { //Comprobamos que los parametros son correctos
            //Obtenemos los parametros
            nombreArchivo = args[0].trim();
            ipServidor = args[1].trim();
            puertoServidor = Short.parseShort(args[2]);
            ipSR = args[3].trim();
            puertoSR = Integer.parseInt(args[4].trim());
        
            try {
                archivo = new FileInputStream(nombreArchivo); //Abrimos el fichero
                datos = archivo.readAllBytes(); //Llenamos el array de bytes con los datos del fichero
                socket = new DatagramSocket(); //Iniciamos el socket
                
                while (true) {
                    buffer = new ByteArrayOutputStream(); //Iniciamos el buffer
                    anhadirDireccionamiento(buffer, ipServidor, puertoServidor); //Obtenemos Ip y puerto, lo escribimos en el buffer
                
                    ce = recorrerFichero(ce, recorrer, buffer, datos);  //Recorremos fichero y escribimos en el buffer
                
                    if (ce != -1) {
                        //Si no es el ultimo paquete vamos enviando y esperando los ACK
                        buffer.write(convertirIntAByteArray(ce)); //ce actuara tambien como ACK
                        paqueteEnv = new DatagramPacket(buffer.toByteArray(), buffer.toByteArray().length, InetAddress.getByName(ipSR), puertoSR); //Iniciamos paquete que vamos a enviar
                        socket.send(paqueteEnv); //Enviamos el paquete env

                        //Espera de recibir el asentimiento
                        ackArray = new byte[18];  //Iniciamos el array que tomara los datos del paquete recibido
                        paqueteRecv = new DatagramPacket(ackArray, ackArray.length);  //Iniciamos el paquete que vamos a recibir
                        
                        try {
                            socket.setSoTimeout(50);  //Establecemos un tiempo de espera para la respuesta del ACK
                            socket.receive(paqueteRecv);  //Recibimos el paquete
                            ack = convertirByteArrayAInt(Arrays.copyOfRange(paqueteRecv.getData(), 6, paqueteRecv.getData().length));  //Recuperramos el ack

                            if(ack == ce + 1) { //Comprobamos que el ack recibido es igual al del siguiente paquete que tenemos que enviar
                                recorrer += 1454;
                                ce++;
                            }
                        } catch (SocketTimeoutException e) {
                        } 
                    } else {
                        paqueteEnv = new DatagramPacket(buffer.toByteArray(), buffer.toByteArray().length, InetAddress.getByName(ipSR), puertoSR);
                        socket.send(paqueteEnv);

                        finalizar(buffer, socket, archivo);
                    }
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error en formato, el formato es: ro2021send input_file dest_IP dest_port emulator_IP emulator_port");
        }
    }

    public static int recorrerFichero(int ce, int recorrer, ByteArrayOutputStream buffer, byte[] datos) {
        try {
            if((recorrer + 1454) < datos.length) {
                buffer.write(Arrays.copyOfRange(datos, recorrer, recorrer + 1454));
            } else if (recorrer > datos.length) { //Final del fichero
                ce = -1;
            } else {
                buffer.write(Arrays.copyOfRange(datos, recorrer, datos.length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ce;
    }

    public static byte[] convertirIntAByteArray(int valor) {
        return new byte[] {
            (byte) (valor >> 24),
            (byte) (valor >> 16),
            (byte) (valor >> 8),
            (byte) valor 
        };
    }

    public static int convertirByteArrayAInt(byte[] valor) {
        return ((valor[0] & 0xFF) << 24) |
                ((valor[1] & 0xFF) << 16) |
                ((valor[2] & 0xFF) << 8) |
                ((valor[3] & 0xFF) << 0);
    }

    public static void finalizar(ByteArrayOutputStream buffer, DatagramSocket socket, FileInputStream archivo) {
        System.out.println("Envio del archivo finalizado");

        try {
            buffer.close();
            socket.close();
            archivo.close();
            System.exit(0); //final
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
    //Metodo para escribir la IP y puerto para añadirlo al paquete
    public static void anhadirDireccionamiento(ByteArrayOutputStream buffer, String IP, short puerto) {
        InetAddress IPAddress;
        ByteBuffer bufferAux;

        try{
            IPAddress = InetAddress.getByName(IP);
            buffer.write(IPAddress.getAddress());
            bufferAux = ByteBuffer.allocate(2);
            bufferAux.putShort(puerto);
            buffer.write(bufferAux.array());
        }catch(IOException e){
            e.printStackTrace();
        }
    }  
}