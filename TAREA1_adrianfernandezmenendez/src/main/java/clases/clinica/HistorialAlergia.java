package clases.clinica;

import java.util.Map;
import java.util.Set;

public class HistorialAlergia {
	// Carga pesada
	private Map<Historial, Set<Alergia>> historialConAlergias;
	private Map<Alergia, Set<Historial>> alergiaConHistoriales;

	// Carga media (Ligera,Pesada)
	private Map<Long, Set<Alergia>> idHistorialConAlergias;
	private Map<Long, Set<Historial>> idAlergiaConHistorial;

	// Carga media (Pesada, Ligera)
	private Map<Alergia, Set<Long>> alergiaIdHistorial;
	private Map<Historial, Set<Long>> historialIdAlergias;

	// Carga ligera
	private Map<Long, Set<Long>> idConId;

	// Constructor
	public HistorialAlergia() {

	}

	// Getters y Setters
	public Map<Historial, Set<Alergia>> getHistorialConAlergias() {
		return historialConAlergias;
	}

	public void setHistorialConAlergias(Map<Historial, Set<Alergia>> historialConAlergias) {
		this.historialConAlergias = historialConAlergias;
	}

	public Map<Alergia, Set<Historial>> getAlergiaConHistoriales() {
		return alergiaConHistoriales;
	}

	public void setAlergiaConHistoriales(Map<Alergia, Set<Historial>> alergiaConHistoriales) {
		this.alergiaConHistoriales = alergiaConHistoriales;
	}

	public Map<Long, Set<Alergia>> getIdHistorialConAlergias() {
		return idHistorialConAlergias;
	}

	public void setIdHistorialConAlergias(Map<Long, Set<Alergia>> idHistorialConAlergias) {
		this.idHistorialConAlergias = idHistorialConAlergias;
	}

	public Map<Long, Set<Historial>> getIdAlergiaConHistorial() {
		return idAlergiaConHistorial;
	}

	public void setIdAlergiaConHistorial(Map<Long, Set<Historial>> idAlergiaConHistorial) {
		this.idAlergiaConHistorial = idAlergiaConHistorial;
	}

	public Map<Alergia, Set<Long>> getAlergiaIdHistorial() {
		return alergiaIdHistorial;
	}

	public void setAlergiaIdHistorial(Map<Alergia, Set<Long>> alergiaIdHistorial) {
		this.alergiaIdHistorial = alergiaIdHistorial;
	}

	public Map<Historial, Set<Long>> getHistorialIdAlergias() {
		return historialIdAlergias;
	}

	public void setHistorialIdAlergias(Map<Historial, Set<Long>> historialIdAlergias) {
		this.historialIdAlergias = historialIdAlergias;
	}

	public Map<Long, Set<Long>> getIdConId() {
		return idConId;
	}

	public void setIdConId(Map<Long, Set<Long>> idConId) {
		this.idConId = idConId;
	}

}
