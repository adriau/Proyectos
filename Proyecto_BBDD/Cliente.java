import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Cliente {
	static final String IDADMIN = "admin";
	static final String PASS = "admin";

	static final String [] errors = null;

	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			String link = "jdbc:mysql://localhost/";
			String user = "root";
			String password = "root";
			String baseDatos = "TaquillaVirtual?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Base de datos conectada.");
			Connection conexion = null;
			Statement state = null;
			conexion = DriverManager.getConnection(link + baseDatos, user, password);
			state = conexion.createStatement();
			while (true) {
				menu(scan, state);
			}
		} catch (SQLException e) {
			System.out.println("Que ha pachado");
			e.printStackTrace();
		} catch (Exception e) {

		}

	}

	private static void menu(Scanner scan, Statement state) throws SQLException {
		String sql = null;
		System.out.println("Escoja que acción desea realizar:");
		System.out.println(" 1.  Crear un nuevo Espectaculo");
		System.out.println(" 2.  Eliminar Espectaculo");
		System.out.println(" 3.  Eliminar Tipo usuario de un Evento");    
		System.out.println(" 4.  Modificar estado de una Localidad");		
		System.out.println(" 5.  Eliminar un Evento asociado a un Espectaculo");   
		System.out.println(" 6.  Cambiar el estado de un Evento");
		System.out.println(" 7.  Mostrar eventos disponibles");
		System.out.println(" 8.  Modificacion del estado de un Evento con las credenciales del cliente");  
		System.out.println(" 9.  Añadir un cliente al sistema");
		System.out.println(" 10. Consultar los datos de un cliente");
		System.out.println(" 11. Filtrar Eventos");
		System.out.println(" 12. Consultar precio de una localidad");   
		System.out.println(" 13. Anular una compra");
		System.out.println(" 14. Consultar localidades disponibles de una Grada en un Evento");
		System.out.println(" 15. Comprar entrada");
		System.out.println(" 16. Pre reservar una entrada.");
		System.out.println(" 17. Salir ");
		System.out.println();
		String respuesta = scan.nextLine();
		switch (Integer.valueOf(respuesta)) {
		case 1:
			System.out.println("Has seleccionado crear un nuevo Evento.\n");
			if (comprobarPermisos(scan)) {
				addEvento(scan, state, sql);
			}
			break;
		case 2:
			System.out.println("Has seleccionado eliminar un Espectáculo\n");
			if (comprobarPermisos(scan)) {
				deleteEspectaculo(scan, state, sql);
			}
			break;
		case 3:
			System.out.println("Eliminar Tipo usuario de un Evento\n");
            if (comprobarPermisos(scan)) {
                modifyEspectaculo(scan, state, sql);
            }
			break;
		case 4:
			System.out.println("Modificar el Estado de una localidad\n");
			if (comprobarPermisos(scan)) {
				modifyLocalidad(scan, state, sql);
			}
			break;
		case 5:
			System.out.println("Has seleccionado eliminar un Evento\n");
			if (comprobarPermisos(scan)) {
				deleteEvento(scan, state, sql);
			}
			break;
		case 6:
			System.out.println("Has seleccionado cambiar el estado de un Evento\n");
			if (comprobarPermisos(scan)) {
				cambiarEstado(scan, state, sql);
			}
			break;
		case 7:
			System.out.println("Has seleccionado ver la lista de eventos disponibles\n");
			listarEspectaculos(state, sql);
			break;
		case 8:
			System.out.println("Has seleccionado cambiar el estado de un Evento\n");
			if (comprobarPermisos(scan)) {
				cambiarEstado(scan, state, sql);
			}
			break;
		case 9:
			System.out.println("Ha seleccionado registrar un nuevo cliente.\n");
			addCliente(scan, state, sql);
			break;
		case 10:
			System.out.println("Ha seleccionado consultar sus datos personales.\n");
			buscarCliente(scan, state, sql);
			break;
		case 11:
			System.out.println("Has seleccionado filtrar Espectaculos\n");
			filtarEspectaculos(state, sql, scan);
			break;
		case 12:
			System.out.println("Has seleccionado consultar el precio de una Localidad\n");
			consultarPrecio(scan, state, sql);
			break;
		case 13:
			System.out.println("Ha solicitado anular la compra de una/s Localidad\n");
			anularLocalidad(scan, state, sql);
			break;
		case 14:
			System.out.println("Has seleccionado consultar las localidades de una Grada en un Evento\n");
			consultarLocalidad(scan, state, sql);
			break;
		case 15:
			System.out.println("Ha seleccionado comprar entrada.\n");
			comprarEntrada(scan, state, sql);
			break;
		case 16:
			System.out.println("Has seleccionado pre reservar una entrada");
			prereservarEntrada(scan, state, sql);
			break;
		case 17:
			System.out.println("Has seleccionado salir.");
			System.exit(0);
		default:
			System.out.println("La opción seleccionada no es válida.");
			System.exit(0);
		}

	}

	private static void prereservarEntrada(Scanner scan, Statement state, String sql) {
		try {

			System.out.println("¿Qué evento desea consultar la disponibilidad de localidades?\n");
			String consulta = "SELECT ev.idEvento,e.NombreEspectaculo from Espectaculo e\n"
					+ "INNER join Evento ev on ev.idEspectaculo = e.idEspectaculo\n" + "where estado='abierto'";
			String id = null;
			String nombreRecinto = null;
			String idRecinto = null;
			String idGrada = null;
			try {
				ResultSet answer = state.executeQuery(consulta);

				while (answer.next()) {
					System.out.println(
							"id: " + answer.getString("idEvento") + "   Evento: " + answer.getString("NombreEspectaculo") + "\n");
				}
				System.out.println("Introduzca el id:");
				id = scan.nextLine();
				sql = "SELECT DISTINCT r.Nombre FROM Evento_Grada e \n"
						+ "INNER JOIN Recinto r ON r.idRecinto=e.idRecinto\n" + "WHERE e.idEvento='" + id + "'";
				answer = state.executeQuery(sql);
				while (answer.next()) {
					nombreRecinto = answer.getString("Nombre");
					System.out.println(
							"Has seleccionado el evento " + id + " que se celebra en: " + answer.getString("Nombre"));
				}
				sql = "select idRecinto from Recinto where Nombre='" + nombreRecinto + "'";
				answer = state.executeQuery(sql);
				if (answer.next()) {
					idRecinto = answer.getString("idRecinto");
				}
				sql = "select idGrada,Nombre from Grada where idRecinto='" + idRecinto + "'";
				System.out.println("\nIndique en cuál de las siguientes gradas desea consultar\n");
				answer = state.executeQuery(sql);
				while (answer.next()) {
					System.out
							.println("Grada:" + answer.getString("idGrada") + " Nombre: " + answer.getString("Nombre"));
				}
				System.out.println("\nIntroduzca el id de la grada:\n");
				idGrada = scan.nextLine();
				sql = "select idLocalidad from Localidad where idRecinto='" + idRecinto + "' and idGrada='" + idGrada
						+ "'";
				answer = state.executeQuery(sql);
				while (answer.next()) {
					System.out.println("ID Localidad: " + answer.getString("idLocalidad"));
				}
			} catch (SQLException e) {

			}

			System.out.println("Introduzca el id o ids de las localidades que desea pre reservar: ");
			String idLocalidad = scan.nextLine();
			System.out.println("Introduzca su dni:");
			String dni = scan.nextLine();
			System.out.println("Introduzca el tipo de usuario para el que pre reserva la entrada:");
			String tipo = scan.nextLine();
			String idLocalidadAux[] = idLocalidad.split(" ");
			for (int i = 0; i < idLocalidadAux.length; i++) {
				String query = "call reservar(" + Integer.valueOf(id) + "," + Integer.valueOf(idGrada) + ","
						+ Integer.valueOf(idLocalidadAux[i]) + ",'" + tipo + "','" + dni + "',@idReserva);";
				ResultSet rs = state.executeQuery(query);

				query = "SELECT @idReserva;";
				rs = state.executeQuery(query);
				String idError = null;
				while (rs.next()) {
					idError = rs.getString("@idReserva");
					if (Integer.valueOf(idError) > 0) {
						System.out.println("Resultado de la Prerreserva " + (i + 1) + ": " + idError);
					} else {
						errores(idError);
					}
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void modifyLocalidad(Scanner scan, Statement state, String sql){
		try {
			sql = "SELECT * from Recinto";
			ResultSet answer = state.executeQuery(sql);

			while (answer.next()) {
				System.out.println(
					"id: "+ answer.getString("idRecinto")
					+" --- Nombre: "+ answer.getString("Nombre")+"\n");
						
			}

			System.out.println("De que Recinto quieres modificar el estado de una localidad?");
			String recinto = scan.nextLine();
			sql = "SELECT * from Grada WHERE idRecinto ='"+ recinto +"'";
			answer = state.executeQuery(sql);

			while (answer.next()) {
				System.out.println(
					"id: "+ answer.getString("idGrada")
					+" --- Nombre: "+ answer.getString("Nombre")+"\n");
						
			}
			System.out.println("A que grada pertenece?");
			String grada = scan.nextLine();
			sql = "SELECT * from Localidad WHERE idRecinto ='"+ recinto +"' and idGrada ='" + grada + "'";
			answer = state.executeQuery(sql);

			while (answer.next()) {
				System.out.println(
					"id: "+ answer.getString("idLocalidad")
					+" --- Estado: "+ answer.getString("Estado")+"\n");
						
			}

			System.out.println("Cual es la localidad?");
			String localidad = scan.nextLine();
			sql = "SELECT DISTINCT l.idRecinto,l.idGrada, l.idLocalidad, l.Estado  from Localidad l "
				+"where l.idRecinto='"+recinto+"' and l.idGrada='"+grada+"' and l.idLocalidad='"+localidad+"'";
			
			answer = state.executeQuery(sql);
			while (answer.next()) {
				System.out.println(
						" id: " + answer.getString("idRecinto") 
						+ " --- Grada: " + answer.getString("idGrada")
						+ " --- Localidad: " + answer.getString("idLocalidad") 
						+ " --- Estado: "+answer.getString("Estado")+"\n");
			}
			System.out.println("Cual es el nuevo estado que le quieres ortorgar? (Libre/Deteriorado)");
			String estado = scan.nextLine();
			if(!estado.equals("")){
				sql="update Localidad set Estado ='"+estado+"' where idRecinto='" + recinto 
				+ "' and idGrada='"+grada+"' and idLocalidad='"+localidad+"'";
				state.executeUpdate(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//TODO: handle exception
		}
	}

	private static void modifyEspectaculo(Scanner scan, Statement state, String sql){
		try{
			String id = "";
			String usuario = "";
			String cambio = "";
			int aux =0;
			String gradas ="";

			sql = "SELECT DISTINCT ev.idEvento, es.NombreEspectaculo, es.Tipo from Evento ev "
				+"INNER JOIN Espectaculo es on es.idEspectaculo = ev.idEspectaculo ";
			ResultSet answer = state.executeQuery(sql);
			while (answer.next()) {
				System.out.println(
						" id: " + answer.getString("idEvento") 
						+ " --- Nombre del Espectaculo: " + answer.getString("NombreEspectaculo")
						+ " --- Tipo: " + answer.getString("Tipo") +"\n");
			}
			System.out.println("Que evento (id) quieres modificar?");
			id = scan.nextLine();
			sql= "SELECT DISTINCT ev.idEvento ,ev_gr.Usuario, ev_gr.idGrada from Evento ev "
				+"INNER JOIN Evento_Grada ev_gr on ev_gr.idEvento = ev.idEvento "
				+"where ev.idEvento='"+id+"'";
			answer = state.executeQuery(sql);
			
			while (answer.next()) {
				System.out.println(
						" id: " + answer.getString("idEvento") 
						+ " --- Tipo de Usuario: " + answer.getString("Usuario") 
						+ " --- Grada: "+answer.getString("idGrada")+"\n");
				aux=Integer.parseInt(answer.getString("idGrada"));
			}
			
			if(aux!=1){
				System.out.println("Hay disponibles : "+aux+" gradas\nA que grada le quieres cambiar el usuario?");
				gradas=scan.nextLine();
			}
			
			System.out.println("Que tipo de usuario quieres eliminar?");
			usuario = scan.nextLine();
			
			if(id.equals("") || usuario.equals("") || gradas.equals("")){
				return;
			}
			sql="DELETE FROM Evento_Grada where idEvento='" + id 
				+ "' and Usuario='"+usuario+"' and idGrada='"+gradas+"'";
			
			state.executeUpdate(sql);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void listarEspectaculos(Statement state, String sql) {
		System.out.println("Esta es la lista de eventos disponibles:\n");
		sql = "SELECT e.NombreEspectaculo, ev.fecha, ev.hora from Espectaculo e\n"
				+ "INNER join Evento ev on ev.idEspectaculo = e.idEspectaculo\n" + "where estado='abierto'";
		try {
			ResultSet answer = state.executeQuery(sql);

			while (answer.next()) {
				System.out.println("Evento: " + answer.getString("NombreEspectaculo") + "   Fecha: " + answer.getString("fecha")
						+ "  Hora: " + answer.getString("hora") + "\n");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private static String addEspectaculo(Scanner scan, Statement state, String sql) {
		System.out.println("Introduzca de que tipo será:");
		String tipo = scan.nextLine();
		if(tipo.equals("")){
			errores("-12");
			System.out.println();
			return null;
		}
		System.out.println("Introduzca que se celebrará:");
		String NombreEspectaculo = scan.nextLine();
		if(NombreEspectaculo.equals("")){
			errores("-12");
			System.out.println();
			return null;
		}
		System.out.println("Introduzca una descripción (opcional):");
		String descripcion = scan.nextLine();
		sql = "insert into Espectaculo values(" + null + ",'" + tipo + "','" + NombreEspectaculo + "','" + descripcion + "')";
		try {
			state.executeUpdate(sql);
			return NombreEspectaculo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void anularLocalidad(Scanner scan, Statement state, String sql) {

		try{
			System.out.println("Introduce tu DNI");
			String DNI = scan.nextLine();
			sql = "select * from Ventas " 
				+"where dniCliente='"+DNI+"'";
			ResultSet answer = state.executeQuery(sql);
			int sum =0;
			while (answer.next()) {
				System.out.println(
					"id: " + answer.getString("idCompra") 
					+ " --- idEvento: " + answer.getString("idEvento") 
					+ " --- idRecinto: " + answer.getString("idRecinto") 
					+ " --- idGrada: " + answer.getString("idGrada") 
					+ " --- idLocalidad: " + answer.getString("idLocalidad") 
					+ " --- Fecha de Compra: " + answer.getString("fechaCompra") 
					+ "\n");
				sum++;
		}
		if(sum!=0){
			System.out.println("¿Cual es la compra (idCompra) que quieres anular?");
			String anular = scan.nextLine();
			sql = "select * from Ventas " 
				+"where dniCliente='"+DNI+"' and idCompra='"+anular+"'";
			answer = state.executeQuery(sql);
			String idEvento="";
			String idGrada="";
			String idLocalidad="";

			while(answer.next()){
				idEvento=answer.getString("idEvento");
				idGrada = answer.getString("idGrada");
				idLocalidad = answer.getString("idLocalidad");
			}
			String query = "call anular(" + Integer.valueOf(idEvento) 
						   + "," + Integer.valueOf(idGrada) 
						   + "," + Integer.valueOf(idLocalidad) 
						   + ",'" + DNI + "',@Penalizacion);";
			answer = state.executeQuery(query);
			query = "SELECT @Penalizacion;";
			answer = state.executeQuery(query);
		
			String idError = null;
			while (answer.next()) {
				idError = answer.getString("@Penalizacion");
				if (Integer.valueOf(idError) >= 0) {
					System.out.println("Se ha anulado correctamente "+idError);
				} else {
					errores(idError);
					
				}
			}
		}else{
			System.out.println("\nNo tienes niguna compra pendiente\n");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void consultarLocalidad(Scanner scan, Statement state, String sql) {
		System.out.println("¿Qué evento desea consultar la disponibilidad de localidades?\n");
		String consulta = "SELECT ev.idEvento,e.NombreEspectaculo from Espectaculo e\n"
				+ "INNER join Evento ev on ev.idEspectaculo = e.idEspectaculo\n" + "where estado='abierto'";
		String id = null;
		String nombreRecinto = null;
		String idRecinto = null;
		try {
			ResultSet answer = state.executeQuery(consulta);

			while (answer.next()) {
				System.out.println(
						"id: " + answer.getString("idEvento") + "   Evento: " + answer.getString("NombreEspectaculo") + "\n");
			}
			System.out.println("Introduzca el id:");
			id = scan.nextLine();
			sql = "SELECT DISTINCT r.Nombre FROM Evento_Grada e \n"
					+ "INNER JOIN Recinto r ON r.idRecinto=e.idRecinto\n" + "WHERE e.idEvento='" + id + "'";
			answer = state.executeQuery(sql);
			while (answer.next()) {
				nombreRecinto = answer.getString("Nombre");
				System.out.println(
						"Has seleccionado el evento " + id + " que se celebra en: " + answer.getString("Nombre"));
			}
			sql = "select idRecinto from Recinto where Nombre='" + nombreRecinto + "'";
			answer = state.executeQuery(sql);
			if (answer.next()) {
				idRecinto = answer.getString("idRecinto");
			}
			sql = "select idGrada,Nombre from Grada where idRecinto='" + idRecinto + "'";
			System.out.println("\nIndique en cuál de las siguientes gradas desea consultar\n");
			answer = state.executeQuery(sql);
			while (answer.next()) {
				System.out.println("Grada:" + answer.getString("idGrada") + " Nombre: " + answer.getString("Nombre"));
			}
			System.out.println("\nIntroduzca el id de la grada:\n");
			String idGrada = scan.nextLine();
			sql = "select idLocalidad from Localidad where idRecinto='" + idRecinto + "' and idGrada='" + idGrada
					+ "' and Estado='Libre'";
			answer = state.executeQuery(sql);
			while (answer.next()) {
				System.out.println("ID Localidad: " + answer.getString("idLocalidad"));
			}
		} catch (SQLException e) {
	
		}
	}

	private static void consultarPrecio(Scanner scan, Statement state, String sql) {
  
		try {
			System.out.println("Escoja el evento de los siguientes del que quiere consultar los precios.\n");
			sql = "SELECT ev.idEvento,e.NombreEspectaculo from Espectaculo e\n"
				+ "INNER join Evento ev on ev.idEspectaculo = e.idEspectaculo\n"
				+ "where estado='abierto'";
			ResultSet answer = state.executeQuery(sql);
  
			while (answer.next()) {
				System.out.println(
						"id: " + answer.getString("idEvento")
						+ " --- Evento: " + answer.getString("NombreEspectaculo") + "\n");
			}
  
			System.out.println("Introduzca el id:");
			String id = scan.nextLine();
			if(id.equals("")){
				return;
			}
			sql = "SELECT DISTINCT g.Nombre,g.idGrada FROM Evento_Grada e "
				+ "INNER JOIN Grada g on g.idGrada=e.idGrada " + "and g.idRecinto=e.idRecinto "
				+ "WHERE e.idEvento='" + id +"'";
			int sum = 0;
			answer = state.executeQuery(sql);
			while (answer.next()) {
				System.out.println("id: "+ answer.getString("idGrada")
					+" --- NombreGrada: " + answer.getString("Nombre") 
					+"\n");
				sum++;
			}
			if(sum != 1) {
				System.out.println("Sobre que grada quieres ver el precio");
				String grada = scan.nextLine();
				if(grada.equals("")){
					return;
				}
				sql = "SELECT g.Nombre,e.usuario,e.precio FROM Evento_Grada e "
					+ "INNER JOIN Grada g on g.idGrada=e.idGrada " + "and g.idRecinto=e.idRecinto "
					+ "WHERE e.idEvento='" + id + "' and e.idGrada='"+grada+"'";
			} else {
				sql = "SELECT g.Nombre,e.usuario,e.precio FROM Evento_Grada e "
					+ "INNER JOIN Grada g on g.idGrada=e.idGrada " + "and g.idRecinto=e.idRecinto "
					+ "WHERE e.idEvento='" + id + "'";
			}
			answer = state.executeQuery(sql);
  
			while (answer.next()) {
				System.out.println("NombreGrada: " + answer.getString("Nombre")
				+ " --- TipoUsuario: "+ answer.getString("usuario")
				+ " --- Precio: " + answer.getString("precio") + "\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
  
	}
 

	private static void cambiarEstado(Scanner scan, Statement state, String sql) {
		System.out.println("Estos son los eventos y su estado actual:\n");
		sql = " select Evento.idEvento,Espectaculo.NombreEspectaculo,Evento.fecha,Evento.hora,Evento.Estado from Espectaculo \n"
				+ "     inner join Evento on Evento.idEspectaculo=Espectaculo.idEspectaculo where Evento.Estado != 'Finalizado' ";

		try {
			ResultSet answer = state.executeQuery(sql);
			while (answer.next()) {
				System.out.println("ID: " + answer.getString("idEvento") + " EVENTO: " + answer.getString("NombreEspectaculo")
						+ " FECHA: " + answer.getString("fecha") + "  HORA: " + answer.getString("hora") + " ESTADO: "
						+ answer.getString("Estado"));
			}
			System.out.println("Introduzca el id del Evento que desea cambiar de estado: ");
			String id = scan.nextLine();
			sql = "select Estado from Evento where idEvento='" + id + "'";
			answer = state.executeQuery(sql);
			if (answer.next()) {
				String Estado = answer.getString("Estado");
				if (Estado.equals("Abierto")) {
					sql = "update Evento set Estado='Cerrado' where idEvento='" + id + "'";
				} else {
					sql = "update Evento set Estado='Abierto' where idEvento='" + id + "'";
				}
				state.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void deleteEspectaculo(Scanner scan, Statement state, String sql) {
		System.out.println("Lista de Espectáculos disponibles\n");
		sql = "select idEspectaculo,NombreEspectaculo from Espectaculo";
		try {
			ResultSet answer = state.executeQuery(sql);
			while (answer.next()) {
				System.out.println(
						"ID: " + answer.getString("idEspectaculo") + "  ESPECTACULO: " + answer.getString("NombreEspectaculo"));
			}
			System.out.println("Introduzca el id del espectáculo que desea eliminar:");
			String id = scan.nextLine();
			sql = "delete from Participantes where idEspectaculo='" + id + "'";
			state.executeUpdate(sql);
			sql = "select idEvento from Evento where idEspectaculo='" + id + "'";
			answer = state.executeQuery(sql);
			String idEvento = null;
			String idAux = "";
			while (answer.next()) {
				idEvento = answer.getString("idEvento");
				idAux += idEvento + " ";
			}
			String[] idSplit = idAux.split(" ");
			for (int j = 0; j < idSplit.length; j++) {
				sql = "delete from Evento_Grada where idEvento='" + idSplit[j] + "'";
				state.executeUpdate(sql);
			}
			sql = "delete from Evento where idEspectaculo='" + id + "'";
			state.executeUpdate(sql);
			sql = "delete from Espectaculo where idEspectaculo='" + id + "'";
			state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void deleteEvento(Scanner scan, Statement state, String sql) {
		sql = " select Evento.idEvento,Espectaculo.NombreEspectaculo,Evento.fecha,Evento.hora from Espectaculo \n"
				+ "     inner join Evento on Evento.idEspectaculo=Espectaculo.idEspectaculo where Evento.Estado = 'Abierto' ";
		try {
			System.out.println("Lista de Eventos disponibles\n");
			ResultSet answer = state.executeQuery(sql);
			while (answer.next()) {
				System.out.println("ID: " + answer.getString("idEvento") + " EVENTO: " + answer.getString("NombreEspectaculo")
						+ " FECHA: " + answer.getString("fecha") + "  HORA: " + answer.getString("hora"));

			}
			System.out.println("Introduzca el id del evento de que desea eliminar: ");
			String id = scan.nextLine();
			sql = "Delete from Evento_Grada where idEvento='" + id + "'";
			state.executeUpdate(sql);
			sql = "Delete from Evento where idEvento='" + id + "'";
			state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void addEvento(Scanner scan, Statement state, String sql) {
		String NombreEspectaculo = addEspectaculo(scan, state, sql);
		String idEspectaculo = null;
		sql = "select idEspectaculo from Espectaculo where NombreEspectaculo='" + NombreEspectaculo + "'";
		try {
			ResultSet answer = state.executeQuery(sql);
			while (answer.next()) {
				idEspectaculo = answer.getString("idEspectaculo");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("En que Recinto tendrá lugar:");
		String recinto = scan.nextLine();
		
		System.out.println("Cuál será el aforo máximo:");
		String aforo = scan.nextLine();
		String idRecinto = null;
		sql = "select idRecinto from Recinto where Nombre='" + recinto + "'";
		try {
			ResultSet answer = state.executeQuery(sql);
			while (answer.next()) {
				idRecinto = answer.getString("idRecinto");
			}
			if (idRecinto == null) {
				sql = "insert into Recinto values (" + null + ",'" + recinto + "','" + Integer.valueOf(aforo) + "')";
				state.executeUpdate(sql);
			}
		} catch (SQLException e) {

		}
		System.out.println("Qué día se celebrará:(yyyy:mm:dd)");
		String fecha = scan.nextLine();
		System.out.println("A qué hora:(hh:mm:ss)");
		String hora = scan.nextLine();
		System.out.println("Duración máxima de una pre reserva:");
		String t1 = scan.nextLine();
		System.out.println("Minutos hasta el inicio del evento donde está permitida la comprar:");
		String t2 = scan.nextLine();
		System.out.println("A falta de cuántos minutos las anulaciones tendrán recarga: ");
		String t3 = scan.nextLine();
		
		sql = "insert into Evento values(" + null + ",'" + idEspectaculo + "','Abierto','" + fecha + "','" + hora
				+ "','" + Integer.valueOf(t1) + "','" + Integer.valueOf(t2)
				+ "','" + Integer.valueOf(t3) + "')";
		try {
			state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void filtarEspectaculos(Statement state, String sql, Scanner scan) throws SQLException {

		System.out.println("Seleccione el criterio por el cual quiere filtrar: \n");
		System.out.println("1. Participante ");
		System.out.println("2. Nombre del espectáculo");
		System.out.println("3. Tipo del espectáculo");
		System.out.println("4. Fecha");
		System.out.println("5. Recinto");
		String eleccion = scan.nextLine();
		switch (Integer.valueOf(eleccion)) {
		case 1:
			System.out.println("Introduzca el Participante:");
			String filtrado = scan.nextLine();
			System.out.println("\n\n--Filtrando la búsqueda por PARTICIPANTE=" + filtrado);
			sql = "CALL filtrar('Participante', '" + filtrado.replace(" ", "-") + "');";
			ResultSet proc = state.executeQuery(sql);
			busqueda(state, sql);
			break;
		case 2:
			System.out.println("Introduzca el nombre del espectáculo:");
			filtrado = scan.nextLine();
			System.out.println("\n\n--Filtrado por NOMBER DEL ESPECTACULO:" + filtrado);
			sql = "CALL filtrar('NombreEspectaculo', '" + filtrado.replace(" ", "-") + "');";
			proc = state.executeQuery(sql);
			busqueda(state, sql);
			break;
		case 3:

			System.out.println("Introduzca el tipo de Espectaculo:");
			filtrado = scan.nextLine();
			System.out.println("\n\n--Filtrado por TIPO DE  ESPECTACULO:" + filtrado);
			sql = "CALL filtrar('Tipo', '" + filtrado + "');";
			proc = state.executeQuery(sql);
			busqueda(state, sql);
			break;
		case 4:
			System.out.println("Introduzca la fecha (yyyy-mm-dd):");
			filtrado = scan.nextLine();
			System.out.println("\n\n--Filtrado por FECHA DEL EVENTO:" + filtrado);
			sql = "CALL filtrar('Fecha', '" + filtrado + "');";
			proc = state.executeQuery(sql);
			busqueda(state, sql);
			break;
		case 5:
			System.out.println("Introduzca el Recinto:");
			filtrado = scan.nextLine();
			System.out.println("\n\n--Filtrado por RECINTO:" + filtrado);
			sql = "CALL filtrar('Recinto', '" + filtrado.replace(" ", "-") + "');";
			proc = state.executeQuery(sql);
			busqueda(state, sql);
			break;
		default:
			break;
		}

	}

	private static void busqueda(Statement state, String sql) {

		String idEspectaculo = "";

		System.out.println(
				"-----------------------------------------------------------------------------------------------------");

		try {
			sql = "SELECT * FROM Espectaculo natural join (select * from Evento natural join Resultado)a;";

			ResultSet evento = state.executeQuery(sql);
			while (evento.next()) {

				System.out.println("Id del Evento: " + evento.getString("idEvento")
						+ "\nFecha: " + evento.getString("Fecha")
						+ "\nHora: " + evento.getString("Hora")
						+ "\n Nombre del Espectáculo: " + evento.getString("NombreEspectaculo")
						+ "\nTipo de Espectáculo: " + evento.getString("Tipo")
						+ "\nDescripcion: " + evento.getString("Descripcion") + "\n");
				System.out.println(
						"-----------------------------------------------------------------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void buscarCliente(Scanner scan, Statement state, String sql) {

		System.out.println("Introduzca su DNI");
		String id = "'" + scan.nextLine() + "'";
		sql = "select * from Cliente where DNI=" + id;
		try {
			ResultSet answer = state.executeQuery(sql);
			if (!(answer.next())) {
				System.out.println("No existe ningún cliente con identificador: " + id);
				return;
			} else {
				System.out.println("Introduzca su contraseña:");
				String passwd = scan.nextLine();

				if (answer.getString("passwd").trim().equals(passwd)) {
					String nombre = answer.getString("Nombre");
					String apellidos = answer.getString("Apellidos");
					String dni = answer.getString("DNI");
					String dniBien = dni;
					String iban = answer.getString("IBAN");
					System.out.println("DNI: " + dni + "\n" + "Nombre: " + nombre + "\n" + "Apellidos: " + apellidos
							+ "\n" + "IBAN: " + iban + "\n");
					System.out.println("¿Desea modificarlos?(S/n):");
					String opcion = scan.nextLine();
					
					if (opcion.equals("s")) {
						System.out.println("Cambie el valor o pulse enter para dejarlo como estaba");
						System.out.println("Nombre: ");
						nombre = scan.nextLine();
						System.out.println("Apellidos: ");
						apellidos = scan.nextLine();
						System.out.println("DNI: ");
						dni = scan.nextLine();
						System.out.println("IBAN: ");
						iban = scan.nextLine();

						sql = "UPDATE Cliente SET ";

						if (!(nombre.equals(""))){
							sql = sql + "Nombre='" + nombre + "'";
						}
						if (!(apellidos.equals(""))) {
							if (!(nombre.equals(""))){
								sql = sql + ", ";
							}
							sql = sql + "Apellidos='" + apellidos + "'";
						}

						if (!(dni.equals(""))) {
							if (!(nombre.equals("")) || !(apellidos.equals(""))){
								sql = sql + ", ";
							}
							sql = sql + "DNI='" + dni + "'";
						}

						if (!(iban.equals(""))) {
							if (!(nombre.equals("")) || !(apellidos.equals("")) || !(dni.equals(""))){
								sql = sql + ", ";
							}
							sql = sql + "IBAN='" + iban + "' ";
						}
						if (dni.equals("") && nombre.equals("") && apellidos.equals("") && iban.equals("")) {
							System.out.println("No se ha modificado ningún campo");
						} else {
							sql = sql + " WHERE DNI = '" + dniBien + "'";
							System.out.println(sql);
							state.executeUpdate(sql);
						}

					} else if (opcion.equals("n")) {
						return;
					} else {
						System.out.println("Opción no válida.Datos no modificados.");
					}

				} else {
					System.out.println("No tienes permisos para ver esa información.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void addCliente(Scanner scan, Statement state, String sql) {

		System.out.println("Dni:");
		String dni = scan.nextLine();
		System.out.println("Nombre:");
		String nombre = scan.nextLine();
		System.out.println("Apellidos:");
		String apellidos = scan.nextLine();
		System.out.println("IBAN:");
		String iban = scan.nextLine();
		System.out.println("Contraseña:");
		String passwd = scan.nextLine();
		String apellidosAux[] = apellidos.split(" ");
		if (dni.length() < 9) {
			System.out.println("Error al añadir cliente.La longitud del campo DNI es incorrecta.");
			return;
		} else if (nombre.equals("")) {
			System.out.println("Error al añadir cliente.No se puede dejar un campo en blanco.");
			return;
		} else if (apellidos.equals(" ")) {
			System.out.println("Error al añadir cliente.No se puede dejar un campo en blanco.");
			return;
		} else if (apellidosAux.length < 2) {
			System.out.println("Error al añadir cliente.Debe tener dos apellidos.");
			return;
		} else if (iban.length() < 24) {
			System.out.println("Error al añadir cliente.La longitud del campo IBAN es incorrecta.");
			return;
		}

		sql = "insert into Cliente values ('" + dni + "','" + nombre + "','" + apellidos + "','" + passwd + "','" + iban
				+ "')";
		try{
			state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void comprarEntrada(Scanner scan, Statement state, String sql) {

		try {

			System.out.println("¿Qué evento desea consultar la disponibilidad de localidades?\n");
			String consulta = "SELECT ev.idEvento,e.NombreEspectaculo from Espectaculo e\n"
					+ "INNER join Evento ev on ev.idEspectaculo = e.idEspectaculo\n" + "where estado='abierto'";
			String id = null;
			String nombreRecinto = null;
			String idRecinto = null;
			String idGrada = null;
			try {
				ResultSet answer = state.executeQuery(consulta);

				while (answer.next()) {
					System.out.println(
							"id: " + answer.getString("idEvento") + "   Evento: " + answer.getString("NombreEspectaculo") + "\n");
				}
				System.out.println("Introduzca el id:");
				id = scan.nextLine();
				sql = "SELECT DISTINCT r.Nombre FROM Evento_Grada e \n"
						+ "INNER JOIN Recinto r ON r.idRecinto=e.idRecinto\n" + "WHERE e.idEvento='" + id + "'";
				answer = state.executeQuery(sql);
				while (answer.next()) {
					nombreRecinto = answer.getString("Nombre");
					System.out.println("Has seleccionado el evento " + id + " que se celebra en: " + answer.getString("Nombre"));
				}
				sql = "select idRecinto from Recinto where Nombre='" + nombreRecinto + "'";
				answer = state.executeQuery(sql);
				if (answer.next()) {
					idRecinto = answer.getString("idRecinto");
				}
				sql = "select idGrada,Nombre from Grada where idRecinto='" + idRecinto + "'";
				System.out.println("\nIndique en cuál de las siguientes gradas desea consultar\n");
				answer = state.executeQuery(sql);
				while (answer.next()) {
					System.out.println("Grada:" + answer.getString("idGrada") + " Nombre: " + answer.getString("Nombre"));
				}
				System.out.println("\nIntroduzca el id de la grada:\n");
				idGrada = scan.nextLine();
				sql = "select idLocalidad from Localidad where idRecinto='" + idRecinto + "' and idGrada='" + idGrada
						+ "'";
				answer = state.executeQuery(sql);
				while (answer.next()) {
					System.out.println("ID Localidad: " + answer.getString("idLocalidad"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			System.out.println("Introduzca el id o ids de las localidades que desea comprar: ");
			String idLocalidad = scan.nextLine();
			System.out.println("Introduzca su dni: ");
			String dni = scan.nextLine();
			System.out.println("Introduzca el tipo de usuario para el que compra la entrada: ");
			String tipo = scan.nextLine();
			String idLocalidadAux[] = idLocalidad.split(" ");

			for (int i = 0; i < idLocalidadAux.length; i++) {
				String query = "call comprar(" + Integer.valueOf(id) + "," + Integer.valueOf(idGrada) + ","
						+ Integer.valueOf(idLocalidadAux[i]) + ",'" + tipo + "','" + dni + "',@idCompra);";
				ResultSet rs = state.executeQuery(query);

				query = "SELECT @idCompra;";
				rs = state.executeQuery(query);
				String idError = "";
				while (rs.next()) {
					idError = rs.getString("@idCompra");
					if (Integer.valueOf(idError) > 0) {
						System.out.println("Resultado de la compra " + (i + 1) + ": " + idError);
					} else {
						errores(idError);
					}
				}
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static boolean comprobarPermisos(Scanner scan) {
		System.out.println("Esta tarea solo la puede realizar el administrador, por favor identificate.");
		System.out.println("Introduce el id de administrador:");
		String id = scan.nextLine();
		System.out.println("Introduce la contraseña:");
		String contra = scan.nextLine();
		if (id.equals(IDADMIN) && contra.equals(PASS)) {
			return true;
		} else {
			System.out.println("Acceso denegado.\n");
			return false;
		}
	}

	private static void errores(String idError){
	
		String []error = {"Localidad deteriorada. Imposible realizar la compra"
		,"Localidad ocupada. Imposible realizar la compra"
		,"No se ha podido realizar el pago, la localidad ya la has comprado"
		,"Localidad reservada. Imposible realizar la compra"
		,"Usuario no permitido."
		,"Evento finalizado o cerrado."
		,"No se puede prerreservar porque quedan menos de T2 minutos."
		,"No se puede prerreservar porque la entrada ya esta prerreservada por ti."
		,"Grada o Recinto lleno."
		,"Número máximo de entradas prerreservadas."
		,"Anulacion no valida"
		,"Debe indicar algun dato."};
		System.out.println(error[-(Integer.parseInt(idError)+1)]);
	}
}
