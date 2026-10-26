package clases.sesion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sesion {
	private Usuario u;
	
	public static void login(String nombre, String password) {
		Usuario u;
		try(BufferedReader br = new BufferedReader(new FileReader("src/main/resources/credenciales.txt"))) {
			int contador = 1;
			String linea;
			while((linea = br.readLine())!= null) {
				String[] datos = linea.split("\\|");
				
				if(nombre.equals(datos[0])&&password.equals(datos[1])) {
					u = new Usuario();
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
	public static void logout(){
		
	}
}
