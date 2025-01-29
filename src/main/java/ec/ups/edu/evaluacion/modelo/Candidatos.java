package ec.ups.edu.evaluacion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Candidatos {
	@Id
	private String cedula;
	
	private String nombreCandidatos;
	private String partido;
	private String propuesta;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombreCandidatos() {
		return nombreCandidatos;
	}
	public void setNombreCandidatos(String nombreCandidatos) {
		this.nombreCandidatos = nombreCandidatos;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public String getPropuesta() {
		return propuesta;
	}
	public void setPropuesta(String propuesta) {
		this.propuesta = propuesta;
	}
	@Override
	public String toString() {
		return "Candidatos [cedula=" + cedula + ", nombreCandidatos=" + nombreCandidatos + ", partido=" + partido
				+ ", propuesta=" + propuesta + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
