package clases.sesion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import clases.empleado.CategoriaEnfermero;
import clases.empleado.Cirujano;
import clases.empleado.Empleado;
import clases.empleado.Enfermero;
import clases.empleado.Especialidad;
import clases.empleado.Secretariado;

public class GestionEmpleados {
	private static final String SEPARADOR = "|";
	private static final String SEPARADOR_REGEX = "\\|";

	private static File getCredencialesFile() {
		return new File(Propiedades.getClaveRutaCredenciales());
	}


	private static List<String[]> leerTodosEmpleados() {
		List<String[]> empleados = new ArrayList<>();
		if (!getCredencialesFile().isFile()) {
			return empleados;
		}
		try (BufferedReader br = new BufferedReader(new FileReader(getCredencialesFile()))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				linea = linea.trim();
				if (linea.isEmpty()) {
					continue;
				}
				String[] datos = linea.split(SEPARADOR_REGEX, -1);
				if (datos.length == 4) {
					empleados.add(datos);
				}
			}
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido leer el fichero de credenciales.");
		}
		return empleados;
	}

	private static boolean sobreescribirFichero(List<String[]> empleados) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(getCredencialesFile(), false))) {
			for (String[] datos : empleados) {
				bw.write(datos[0] + SEPARADOR + datos[1] + SEPARADOR + datos[2] + SEPARADOR + datos[3]);
				bw.newLine();
			}
			return true;
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido guardar el fichero de credenciales.");
			return false;
		}
	}

	private static boolean escribirEmpleado(String nombreUsuario, String contrasenia, Empleado empleado) {
		Perfil perfil = obtenerPerfilEmpleado(empleado);
		if (perfil == null) {
			return false;
		}
		String nombreCompleto = empleado.getNombre() + " " + empleado.getApellidos();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(getCredencialesFile(), true))) {
			bw.write(nombreUsuario + SEPARADOR + contrasenia + SEPARADOR + nombreCompleto + SEPARADOR
					+ perfil.toString());
			bw.newLine();
			return true;
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido guardar el empleado.");
			return false;
		}
	}

	private static Perfil obtenerPerfilEmpleado(Empleado empleado) {
		if (empleado instanceof Secretariado) {
			return Perfil.SECRETARIADO;
		} else if (empleado instanceof Enfermero) {
			return Perfil.ENFERMERIA;
		} else if (empleado instanceof Cirujano) {
			return Perfil.CIRUJANO;
		}
		System.err.println("ERROR: tipo de empleado desconocido.");
		return null;
	}

	public static boolean anadirEmpleado(Scanner sc) {
		Empleado empl = null;
		System.out.println("Introduzca el id: ");
		Long id = sc.nextLong();
		sc.nextLine();
		if (id == null) {
			return false;
		}
		System.out.println("Introduzca el nombre del empleado: ");
		String nombre = sc.nextLine();
		System.out.println("Introduzca los apellidos del empleado: ");
		String apellidos = sc.nextLine();
		System.out.println("Introduzca el teléfono del empleado: ");
		String telefono = sc.nextLine();
		System.out.println("Introduzca el email del empleado: ");
		String email = sc.nextLine();
		System.out.println("Introduzca el DNI del empleado: ");
		String dni = sc.nextLine();
		System.out.println("Introduzca la dirección del empleado: ");
		String direccion = sc.nextLine();
		System.out.println("Introduzca el nombre de usuario empleado: ");
		String nUsuario = sc.nextLine();
		if (nUsuario == null) {
			return false;
		}
		System.out.println("Introduzca su contraseña: ");
		String password = sc.nextLine();
		int opcion = -1;
		do {
			System.out.println("Introduzca el tipo de empleado,\n1º Secretariado\n2ºEnfermero\n3ºCirujano");
			opcion = sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			case 1->{
				System.out.println("Se ha elegido el tipo Secretariado,\nintroduzca los años de experiencia: ");
				int num = sc.nextInt();
				sc.nextLine();
				empl = new Secretariado(num);
				System.out.println("Empleado - Secretariado creado correctamente");
			}
			case 2->{
				System.out.println("Se ha elegido el tipo Enfermero,\nintroduzca la categoría (A, B ò C): ");
				Character c;
				do {
					c = sc.next().toUpperCase().charAt(0);
					switch(c) {
					case 'A'->{
						System.out.println("Se ha elegido la categoría A");
						empl = new Enfermero(CategoriaEnfermero.A);
						System.out.println("Empleado - Enfermero creado correctamente");
					}
					case 'B'->{
						System.out.println("Se ha elegido la categoría B");
						empl = new Enfermero(CategoriaEnfermero.B);
						System.out.println("Empleado - Enfermero creado correctamente");
					}
					case 'C'->{
						System.out.println("Se ha elegido la categoría C");
						empl = new Enfermero(CategoriaEnfermero.C);
						System.out.println("Empleado - Enfermero creado correctamente");
					}
					default ->{
						System.out.println("Eso no es una opción, intentelo de nuevo");
					}
					}
				}while(c!='A'||c!='B'||c!='C');
			}
			case 3->{
				System.out.println("Se ha elegido el tipo Cirujano,\nIntroduzca las especialidades correspondientes(1-8): ");
				System.out.println("1. Odontología\n2. Fisioterapia\n3. Ginecología\n4. Cirugía plástica\n5. Digestivo\n6. Cirugía pediátrica\n7. Radiología\n8. Geriatría");
				System.out.println("0 para salir");
				int esp = -1;
				Set<Especialidad> espec = null;
				do {
					esp = sc.nextInt();
					sc.nextLine();
					switch(esp) {
					case 1 ->{
						if(!espec.contains(Especialidad.ODONTOLOGIA)) {
						System.out.println("Has elegido Odontología");
						espec.add(Especialidad.ODONTOLOGIA);
						}
						else System.out.println("Esa especialidad ya está agregada");
					}
					case 2 ->{
						if(!espec.contains(Especialidad.FISIOTERAPIA)) {
						System.out.println("Has elegido Fisioterapia");
						espec.add(Especialidad.FISIOTERAPIA);
						}
						else System.out.println("Esa especialidad ya está agregada");
					}
					case 3 ->{
						if(!espec.contains(Especialidad.GINECOLOGIA)) {
						System.out.println("Has elegido Ginegología");
						espec.add(Especialidad.GINECOLOGIA);
						}
						else System.out.println("Esa especialidad ya está agregada");
					}
					case 4 ->{
						if(!espec.contains(Especialidad.CIRUGIA_PLASTICA)) {
						System.out.println("Has elegido Cirugía plástica");
						espec.add(Especialidad.CIRUGIA_PLASTICA);
						}
						else System.out.println("Esa especialidad ya está agregada");
					}
					case 5 ->{
						if(!espec.contains(Especialidad.DIGESTIVO)) {
						System.out.println("Has elegido Digestivo");
						espec.add(Especialidad.DIGESTIVO);
						}
						else System.out.println("Esa especialidad ya está agregada");
					}
					case 6 ->{
						if(!espec.contains(Especialidad.CIRUGIA_PEDIATRICA)) {
						System.out.println("Has elegido Cirugía pediátrica");
						espec.add(Especialidad.CIRUGIA_PEDIATRICA);
						}
						else System.out.println("Esa especialidad ya está agregada");
					}
					case 7 ->{
						if(!espec.contains(Especialidad.RADIOLOGIA)) {
						System.out.println("Has elegido Radiología");
						espec.add(Especialidad.RADIOLOGIA);
						}
						else System.out.println("Esa especialidad ya está agregada");
					}
					case 8 ->{
						if(!espec.contains(Especialidad.GERIATRIA)) {
						System.out.println("Has elegido Geriatría");
						espec.add(Especialidad.GERIATRIA);
						}
						else System.out.println("Esa especialidad ya está agregada");
					}
					case 9 ->{
						System.out.println("Saliendo...");
					}
					default->{
						System.out.println("Eso no es una opción");
					}
					}
				}while(esp == 0);
				empl = new Cirujano(espec);
			}
			}
		} while (opcion != 1 || opcion != 2 || opcion != 3);
		empl.setId(id);
		empl.setNombre(nombre);
		empl.setApellidos(apellidos);
		empl.setTelefono(telefono);
		empl.setEmail(email);
		empl.setNif(dni);
		empl.setDireccion(direccion);
		if (empl == null) {
			return false;
		}

		Perfil perfil = obtenerPerfilEmpleado(empl);
		System.out.println("=== DATOS DEL NUEVO EMPLEADO ===\n");
		System.out.println("Usuario: " + nUsuario);
		System.out.println("\n"+empl+"\n");
		System.out.println("¿Confirmar el alta del empleado? [Y/n]");
		Character c = sc.next().toLowerCase().charAt(0);
		if (c.equals('n')) {
			System.out.println("Operación cancelada.");
			return false;
		}

		if (escribirEmpleado(nUsuario, password, empl)) {
			System.out.println("Empleado registrado correctamente.");
			return true;
		}
		return false;
	}
}
