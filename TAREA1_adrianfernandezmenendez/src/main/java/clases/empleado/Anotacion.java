package clases.empleado;

import java.util.Set;

public class Anotacion {
	private int duracion;
	private Set<Enfermeria> enfermeros;
	private Set<Cirujano> cirujanos;
	private String material;
	private String desarrollo;
	private String pruebas;
	
	
	public Anotacion() {
		super();
	}

	public Anotacion(int duracion, Set<Enfermeria> enfermeros, Set<Cirujano> cirujanos, String material,
			String desarrollo, String pruebas) {
		this.duracion = duracion;
		this.enfermeros = enfermeros;
		this.cirujanos = cirujanos;
		this.material = material;
		this.desarrollo = desarrollo;
		this.pruebas = pruebas;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Set<Enfermeria> getEnfermeros() {
		return enfermeros;
	}

	public void setEnfermeros(Set<Enfermeria> enfermeros) {
		this.enfermeros = enfermeros;
	}

	public Set<Cirujano> getCirujanos() {
		return cirujanos;
	}

	public void setCirujanos(Set<Cirujano> cirujanos) {
		this.cirujanos = cirujanos;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDesarrollo() {
		return desarrollo;
	}

	public void setDesarrollo(String desarrollo) {
		this.desarrollo = desarrollo;
	}

	public String getPruebas() {
		return pruebas;
	}

	public void setPruebas(String pruebas) {
		this.pruebas = pruebas;
	}
	
	
}
