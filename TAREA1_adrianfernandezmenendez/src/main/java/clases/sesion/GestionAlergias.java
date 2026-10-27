package clases.sesion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import clases.clinica.Alergia;
import clases.clinica.Medicamento;

public class GestionAlergias {
	private static final File CARPETA = new File(Propiedades.getClaveRutaAlergias());
	private static final Pattern PATRON_FICHERO = Pattern.compile("alergia_(\\d+)\\.dat");

	private static File ficheroDe(long id) {
		return new File(CARPETA, "alergia_" + id + ".dat");
	}

	private static File[] listarFicheros() {
		File[] ficheros = CARPETA.listFiles((dir, nombre) -> PATRON_FICHERO.matcher(nombre).matches());
		return (ficheros == null) ? new File[0] : ficheros;
	}

	private static Alergia leerFichero(File f) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
			return (Alergia) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("ERROR: no se ha podido leer " + f.getName());
			return null;
		}
	}

	public static List<Alergia> leerTodasAlergias() {
		List<Alergia> alergias = new ArrayList<>();
		for (File f : listarFicheros()) {
			Alergia a = leerFichero(f);
			if (a != null) {
				alergias.add(a);
			}
		}
		alergias.sort(Comparator.comparing(Alergia::getID));
		return alergias;
	}

	public static void verAlergiasDisponibles() {
		List<Alergia> lista = leerTodasAlergias();
		if (lista.isEmpty()) {
			System.out.println("No hay alergias registradas.");
			return;
		}
		for (Alergia a : lista) {
			System.out.println(a.getID() + " - " + a.getNombre());
		}
	}

	public static boolean escribirAlergia(Alergia alergia) {
		File f = ficheroDe(alergia.getID());
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			oos.writeObject(alergia);
			System.out.println("Alergia registrada con id " + alergia.getID() + ".");
			return true;
		} catch (IOException e) {
			System.err.println("ERROR: no se ha podido guardar la alergia.");
			return false;
		}
	}

	public static boolean anadirAlergia(Scanner sc) {
		System.out.println("Introduce el id: ");
		Long id = sc.nextLong();
		sc.next();
		System.out.println("Introduce el nombre de la alergia: ");
		String nombreAl = sc.nextLine();
		System.out.println("Introduce el nombre del medicamento: ");
		String nombreMed = sc.nextLine();
		System.out.println("Introduce el nombre del principio: ");
		String principio = sc.nextLine();
		System.out.println("Introduce la dosis: ");
		float dosis = sc.nextFloat();
		sc.nextLine();
		if (ficheroDe(id).exists()) {
			System.err.println("ERROR: ya existe un fichero para el id " + id + ".");
			return false;
		}

		Alergia alergia = new Alergia(id, nombreAl);
		Medicamento med = new Medicamento(id, nombreMed, principio, dosis);
		alergia.setMedicamento(med);
		med.setAlergia(alergia);

		System.out.println("Se va a registrar:");
		System.out.println("\n" + alergia + "\n");
		System.out.println("¿Confirmar el alta de la alergia? [Y/n]");
		Character respuesta = sc.nextLine().toLowerCase().charAt(0);
		if (respuesta.equals('y')) {
			return escribirAlergia(alergia);
		} else {
			System.out.println("Operación cancelada.");
			return false;
		}
	}

	public static boolean editarAlergia(Scanner sc) {
		System.out.println("¿Desea ver todas las alergias registradas? [Y/n]");
		Character respuesta = sc.nextLine().toLowerCase().charAt(0);
		if (respuesta.equals('y'))
			verAlergiasDisponibles();
		System.out.println("Introduzca id de la alergia a modificar: ");
		Long id = sc.nextLong();
		sc.nextLine();
		if (id == null || id <= 0) {
			System.err.println("ERROR: El id debe ser un número positivo.");
			return false;
		}
		File f = ficheroDe(id);
		if (!f.isFile()) {
			System.err.println("ERROR; No existe ninguna alergia con id " + id + ".");
			return false;
		}
		System.out.println("=== DATOS ACTUALES ===");
		Alergia alergia = leerFichero(f);
		if (alergia == null || alergia.getMedicamento() == null) {
			System.err.println("ERROR: la alergia no se puede leer o está incompleta.");
			return false;
		}
		System.out.println("\n" + alergia + "\n");
		Medicamento med = alergia.getMedicamento();
		int opcion;
		do {
			System.out.println("Que desea editar: ");
			System.out.println("1.- Nombre de la alergia.");
			System.out.println("2.- Nombre del medicamento.");
			System.out.println("3.- Principio activo del medicamento.");
			System.out.println("4.- Dosis máxima diaria del medicamento.");
			System.out.println("5.- Todos los datos.");
			System.out.println("6.- CANCELAR");

			opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1 -> {
				System.out.println("Introduzca el nombre actualizado de la alergia: ");
				alergia.setNombre(sc.nextLine());
			}

			case 2 -> {
				System.out.println("Introduzca el nombre actualizado del medicamento");
				med.setNombre(sc.nextLine());

			}

			case 3 -> {
				System.out.println("Introduzca el principio activo del medicamento actualizado");
				med.setPrincipioActivo(sc.nextLine());
			}

			case 4 -> {
				System.out.println("Introduzca la dosis máxima diaria actualizada");
				med.setDosisMax(sc.nextFloat());
				sc.nextLine();
			}
			case 5 -> {
				System.out.println("Introduzca el nombre actualizado de la alergia: ");
				alergia.setNombre(sc.nextLine());
				System.out.println("Introduzca el nombre actualizado del medicamento");
				med.setNombre(sc.nextLine());
				System.out.println("Introduzca el principio activo del medicamento actualizado");
				med.setPrincipioActivo(sc.nextLine());
				System.out.println("Introduzca la dosis máxima diaria actualizada");
				med.setDosisMax(sc.nextFloat());
				sc.nextLine();
			}
			case 6 -> {
				System.out.println("Operación cancelada. No se ha modificado nada.\nSaliendo...");
			}

			default -> {
				System.out.println("Opción no válida.");
			}
			}
		} while (opcion != 6);
		System.out.println("=== ALERGIA MODIFICADA ===");
		System.out.println("\n" + alergia + "\n");
		System.out.println("¿Confirmas los cambios? [Y/n]");
		Character c = sc.next().toLowerCase().charAt(0);
		if (c.equals('n')) {
			System.out.println("Operación cancelada. No se ha modificado nada.");
			return false;
		}
		if (escribirAlergia(alergia)) {
			System.out.println("Alergia actualizada.");
			return true;
		}
		return false;
	}

	public static boolean verAlergia(Scanner sc) {
		Character c = sc.next().toLowerCase().charAt(0);
		if (c.equals('y')) {
			verAlergiasDisponibles();
		}
		System.out.println("Introduzca id de la alergia a buscar: ");
		Long id = sc.nextLong();
		sc.nextLine();
		if (id == null || id <= 0) {
			System.err.println("ERROR: El id debe ser un número positivo.");
			return false;
		}
		File f = ficheroDe(id);
		if (!f.isFile()) {
			System.err.println("ERROR: No existe ninguna alergia con id " + id + ".");
			return false;
		}
		Alergia alergia = leerFichero(f);
		if (alergia == null) {
			return false;
		}
		System.out.println("=== DATOS DE LA ALERGIA ===");
		System.out.println("\n" + alergia + "\n");
		return true;
	}

}
