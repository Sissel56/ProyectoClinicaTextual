package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int opcion = -1;
		do {
			System.out.print("========== CLÍNICA DENTAL ==========\nOpción 1: Login\nOpción 2: Salir\n");
			try {
				System.out.println("Introduce la opción: ");
				opcion = sc.nextInt();
				sc.nextLine();
			}catch(InputMismatchException e) {
				System.err.println("Opción tiene que ser un número");
				sc.nextLine();
			}
			switch(opcion){ //Menú principal
				case 1 -> { //Opción 1 (Login)
					System.out.println("Introduce tu nombre de usuario: ");
					String nombre = sc.next();
					System.out.println("Introduce tu contraseña: ");
					String password = sc.next();
					
					try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/credenciales.txt"))) {
						int contador = 1;
						String linea;
						while((linea = br.readLine())!= null) {
							String[] datos = linea.split("\\|");
							
							if(nombre.equals(datos[0])&&password.equals(datos[1])) {
								System.out.println("Bienvenido: "+datos[2]+"\nPerfil: "+datos[3]);
								break;
							}
							else if(contador >= 6) {
								System.out.println("No se ha encontrado al usuario en el sistema");
							}
							contador++;
						}
					}catch(FileNotFoundException e) {
						System.err.println("No se encuentra el archivo");
					}catch(IOException e) {
						System.err.println("Error de lectura");
					}
				}
				
				case 2 -> { //Opción 2
					System.out.println("Saliendo del programa...");
				}
				default -> { //Default
					System.out.println("Eso no es una opción");
				}
				
			}
		}while(opcion != 2);
		
	}

}
