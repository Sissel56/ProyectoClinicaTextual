package clases.sesion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class Propiedades {
	private static final String RUTA_PROPIEDADES = "src/main/resources/application.properties";

	private static final String CLAVE_ADMIN_NOMBRE = "useradmin";
	private static final String CLAVE_ADMIN_PASSWORD = "passwordadmin";
	private static final String CLAVE_RUTA_CREDENCIALES = "rutacredenciales";
	private static final String CLAVE_RUTA_ALERGIAS = "rutaaym";

	private static final Properties PROPS = cargarPropiedades();

	private Propiedades() {

	}
	
	private static Properties cargarPropiedades() {
		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream(RUTA_PROPIEDADES)) {
			props.load(fis);
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: No se ha encontrado el fichero de propiedades: " + RUTA_PROPIEDADES);
		} catch (IOException e) {
			System.err.println("ERROR: No se ha podido leer el fichero de propiedades: " + RUTA_PROPIEDADES);
		}
		return props;
	}

	public static String getClaveAdminNombre() {
		return PROPS.getProperty(CLAVE_ADMIN_NOMBRE);
	}

	public static String getClaveAdminPassword() {
		return PROPS.getProperty(CLAVE_ADMIN_PASSWORD);
	}

	public static String getClaveRutaCredenciales() {
		return PROPS.getProperty(CLAVE_RUTA_CREDENCIALES);
	}

	public static String getClaveRutaAlergias() {
		return PROPS.getProperty(CLAVE_RUTA_ALERGIAS);
	}
	
	
}
