package main;

import java.util.Scanner;

import clases.sesion.GestionAlergias;
import clases.sesion.GestionEmpleados;
import clases.sesion.Perfil;
import clases.sesion.Sesion;

public class Main {
	static Scanner sc = new Scanner(System.in);
	private static Sesion sesion;

	public static void menuInvitado(int op) {
		System.out.println("=== MENU DE INVITADO ===");
		System.out.println("1.- Log In");
		System.out.println("2.- SALIR");
		do {
			switch (op) {
			case 1 -> {
				System.out.println("Login...");
				System.out.println("Nombre: ");
				String user = sc.nextLine();
				System.out.println("Contraseña: ");
				String password = sc.nextLine();
				Sesion.login(user, password);
			}
			case 2 -> {
				System.out.println("Saliendo...");
			}
			}
		} while (op != 2);
	}

	public static void menuAdmin(int op) {
		System.out.println("=== MENU DE ADMINISTRADOR ===");
		System.out.println("1.- Log Out");
		System.out.println("2.- Añadir Empleado");
		System.out.println("3.- Añadir Alergia");
		System.out.println("4.- Editar Alergia");
		System.out.println("5.- Ver Alergia");
		System.out.println("6.- Listar Alergias Registradas");
		GestionAlergias.leerTodasAlergias();
		System.out.println("7.- SALIR");
		do {
			switch (op) {
			case 1 -> {
				System.out.println("Logout...");
				Sesion.logout();
			}
			case 2 -> {
				System.out.println("Añadir empleado...");
				GestionEmpleados.anadirEmpleado(sc);
			}
			case 3 -> {
				System.out.println("Añadir Alergia...");
				GestionAlergias.anadirAlergia(sc);
			}
			case 4 -> {
				System.out.println("Editar Alergia...");
				GestionAlergias.editarAlergia(sc);
			}
			case 5 -> {
				System.out.println("Ver Alergia...");
				GestionAlergias.verAlergia(sc);
			}
			case 6 -> {
				System.out.println("Listar Alergias Registradas...");
				GestionAlergias.leerTodasAlergias();
			}
			case 7 -> {
				System.out.println("Saliendo...");
			}
			}
		} while (op != 7);
	}

	public static void menuSecretariado(int op) {
		System.out.println("=== MENU DE SECRETARIADO ===");
		System.out.println("1.- Log Out");
		Sesion.logout();
		System.out.println("2.- Añadir Empleado");
		GestionEmpleados.anadirEmpleado(sc);
		System.out.println("3.- SALIR");
		do {
			switch (op) {
			case 1 -> {
				System.out.println("Logout...");
				Sesion.logout();
			}
			case 2 -> {
				System.out.println("Añadir empleado...");
				GestionEmpleados.anadirEmpleado(sc);
			}
			case 3 -> {
				System.out.println("Saliendo...");
			}
			}
		} while (op != 3);
	}

	public static void menuEnfermeria(int op) {
		System.out.println("=== MENU DE ENFERMERIA ===");
		System.out.println("1.- Log Out");
		Sesion.logout();
		System.out.println("2.- Añadir Alergia");
		GestionAlergias.anadirAlergia(sc);
		System.out.println("3.- Editar Alergia");
		GestionAlergias.editarAlergia(sc);
		System.out.println("4.- Ver Alergia");
		GestionAlergias.verAlergia(sc);
		System.out.println("5.- Listar Alergias Registradas");
		GestionAlergias.leerTodasAlergias();
		System.out.println("6.- SALIR");
		do {
			switch (op) {
			case 1 -> {
				System.out.println("Logout...");
				Sesion.logout();
			}
			case 2 -> {
				System.out.println("Añadir Alergia...");
				GestionAlergias.anadirAlergia(sc);
			}
			case 3 -> {
				System.out.println("Editar Alergia...");
				GestionAlergias.editarAlergia(sc);
			}
			case 4 -> {
				System.out.println("Ver Alergia...");
				GestionAlergias.verAlergia(sc);
			}
			case 5 -> {
				System.out.println("Listar Alergias Registradas...");
				GestionAlergias.leerTodasAlergias();
			}
			case 6 -> {
				System.out.println("Saliendo...");
			}
			}
		} while (op != 6);
	}

	public static void main(String[] args) {
		System.out.println("INICIO");
		int opcion = -1;
		try {
			do {
			if(sesion == null) {
				System.out.println("Bienvenido Invitado");
				menuInvitado(opcion);
			} else {
				if(sesion.getPerfil().equals(Perfil.ADMINISTRADOR)) {
					System.out.println("Bienvenido "+sesion.getNombreReal());
					System.out.println("1. Menu admin\n2. Salir");
					switch(opcion){
					case 1->{
						menuAdmin(opcion);
					}
					case 2->{
						System.out.println("Saliendo...");
					}
					default ->{
						System.out.println("Eso no es una opción");
					}
					}
				}
				if(sesion.getPerfil().equals(Perfil.SECRETARIADO)) {
					System.out.println("Bienvenido "+sesion.getNombreReal());
					System.out.println("1. Menu secretario\n2. Salir");
					switch(opcion){
					case 1->{
						menuSecretariado(opcion);
					}
					case 2->{
						System.out.println("Saliendo...");
					}
					default ->{
						System.out.println("Eso no es una opción");
					}
					}
				}
				if(sesion.getPerfil().equals(Perfil.ENFERMERIA)) {
					System.out.println("Bienvenido "+sesion.getNombreReal());
					System.out.println("1. Menu enfermeria\n2. Salir");
					switch(opcion){
					case 1->{
						menuEnfermeria(opcion);
					}
					case 2->{
						System.out.println("Saliendo...");
					}
					default ->{
						System.out.println("Eso no es una opción");
					}
					}
				}
				if(sesion.getPerfil().equals(Perfil.CIRUJANO)) {
					System.out.println("Bienvenido "+sesion.getNombreReal());
					System.out.println("1. Logout\n2. Salir");
					switch(opcion){
					case 1->{
						Sesion.logout();
					}
					case 2->{
						System.out.println("Saliendo...");
					}
					default ->{
						System.out.println("Eso no es una opción");
					}
					}
				}
			}
			}while(opcion!=2);
			
		} catch (IllegalStateException e) {
			System.err.println("ERROR: " + e.getMessage());
		}

		System.out.println("FIN");

	}

}
