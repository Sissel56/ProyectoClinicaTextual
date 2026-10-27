package clases.sesion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sesion {

	private static Sesion sesion;

	private String nombreUsu;
	private String nombreReal;
	private Perfil perfil;

	public Sesion() {
	}

	public Sesion(String nombreUsu, String nombreReal, Perfil perfil) {
		this.nombreUsu = nombreUsu;
		this.nombreReal = nombreReal;
		this.perfil = perfil;
	}

	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public static Sesion login(String nUsuario, String password) {
		if (nUsuario.equals("admin") && password.equals("admin")) {
			return autenticarAdmin(nUsuario, password);
		} else {
			sesion = autenticarEmpleado(nUsuario, password);
		}
		return sesion;
	}

	public static Sesion logout() {
		sesion = null;
		return sesion;
	}

	private static Sesion autenticarAdmin(String nUsuario, String password) {
		if (password.equals(Propiedades.getClaveAdminPassword())) {
			sesion.setNombreReal("Administrador");
			sesion.setPerfil(Perfil.ADMINISTRADOR);
			sesion.setNombreUsu(nUsuario);
			return sesion;
		}
		System.err.println("ERROR: La contraseña es incorrecta, inténtelo de nuevo.");
		return null;
	}

	private static Sesion autenticarEmpleado(String nUsuario, String password) {
		try (BufferedReader br = new BufferedReader(new FileReader(new File(Propiedades.getClaveRutaCredenciales())))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");

				if (nUsuario.equals(datos[0]) && password.equals(datos[1])) {
					sesion.setNombreUsu(datos[0]);
					sesion.setNombreReal(datos[2]);
					sesion.setPerfil(Perfil.valueOf(datos[3].toUpperCase()));
					System.out.println("Bienvenido: " + sesion.getNombreReal() + "\nPerfil: " + sesion.getPerfil());
					return sesion;
				}
			}
			System.out.println("No se ha encontrado al usuario en el sistema");
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el archivo");
		} catch (IOException e) {
			System.err.println("Error de lectura");
		}
		return sesion;
	}

}
