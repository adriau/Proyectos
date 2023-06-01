import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;

public class ro2021recv {
    public static void main(String args[]) {
        //Variables parametros
        String nombreArchivo;
        int puerto;

        //Variables
        int ce = 0;
        int cr = 0;
        int tamanho = 0;
        FileOutputStream archivo;
        BufferedOutputStream buffer;  //Buffer para escribir en el fichero
        byte datos[];  //Array de bytes que tendra los datos recibidos del paquete
        DatagramSocket socket;
        DatagramPacket paqueteRecv;
        DatagramPacket paqueteEnv;
        ByteArrayOutputStream bufferArray; //Buffer que emplearemos para añadir el direccionamiento al cliente (send) y el ACK
        InetAddress ipSR;
        int puertoSR;
        byte direccionamientoEnvio[]; //Array de bytes con la IP y puerto del cliente (send)

        if (args.length == 2) {
            //Obtenemos los parametros
            nombreArchivo = args[0].trim();
            puerto = Integer.parseInt(args[1].trim());

            try{
                archivo = new FileOutputStream(nombreArchivo);  //Abrimos el fichero
                buffer = new BufferedOutputStream(archivo);  //Iniciamos el buffer de escritura al fichero
                datos = new byte[1472];  //Iniciamos el array de bytes que contendra los datos que recibamos
                socket = new DatagramSocket(puerto);  //Iniciamos el socket

                while(true) {
                    paqueteRecv = new DatagramPacket(datos, datos.length);

                    try {
                        if(cr != 0) {
                            socket.setSoTimeout(50);
                        }

                        socket.receive(paqueteRecv);
                        tamanho = paqueteRecv.getLength();

                        if(tamanho == 6) {
                            finalizar(buffer, socket, archivo);
                        }

                        ipSR = paqueteRecv.getAddress();  //Obtenemos la IP del shufflerouter
                        puertoSR = paqueteRecv.getPort();  //Obtenemos el puerto del shufflerouter
                        direccionamientoEnvio = Arrays.copyOfRange(paqueteRecv.getData(), 0, 6);  //Obtenemos la direccion del cliente (send)
                        ce = convertirByteArrayAInt(Arrays.copyOfRange(paqueteRecv.getData(), tamanho - 4, tamanho)); //Obtenemos el ACK del paquete

                        if(ce == cr) {
                            buffer.write(Arrays.copyOfRange(paqueteRecv.getData(), 6, tamanho - 4));
                            cr++;
                        } 

                        bufferArray = new ByteArrayOutputStream();
                        bufferArray.write(direccionamientoEnvio);
                        bufferArray.write(convertirIntAByteArray(cr));
                        paqueteEnv = new DatagramPacket(bufferArray.toByteArray(), bufferArray.toByteArray().length, ipSR, puertoSR);
                        socket.send(paqueteEnv);

                    } catch(SocketTimeoutException e) {
                        if(tamanho < 1462){
                            finalizar(buffer, socket, archivo);
                        }
                    }
                }
            } catch(IOException e) {
                e.printStackTrace();
            } 
        } else {
            System.out.println("Error en formato, el formato es: ro2021recv output_file listen_port");
        }  
    }

    public static int convertirByteArrayAInt(byte[] valor) {
        return ((valor[0] & 0xFF) << 24) |
                ((valor[1] & 0xFF) << 16) |
                ((valor[2] & 0xFF) << 8) |
                ((valor[3] & 0xFF) << 0);
    }

    public static byte[] convertirIntAByteArray(int valor) {
        return new byte[] {
            (byte) (valor >> 24),
            (byte) (valor >> 16),
            (byte) (valor >> 8),
            (byte) valor 
        };
    }

    public static void finalizar(BufferedOutputStream buffer, DatagramSocket socket, FileOutputStream archivo) {
        System.out.println("Recepción del archivo finalizado");

        try {
            buffer.close();
            socket.close();
            archivo.close();
            System.exit(0); //final
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}