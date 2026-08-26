package datos;

import java.time.LocalDate;

public class Cajero extends Personal{
	
	private String turnoTrabajo;
	
	public Cajero() {}

	public Cajero(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, LocalDate fechaIngreso,
			float sueldoBase, String turnoTrabajo) {
		super(nombre, apellido, dni, fechaDeNacimiento, fechaIngreso, sueldoBase);
		this.turnoTrabajo = turnoTrabajo;
	}

	public String getTurnoTrabajo() {
		return turnoTrabajo;
	}

	public void setTurnoTrabajo(String turnoTrabajo) {
		this.turnoTrabajo = turnoTrabajo;
	}

	@Override
	public String toString() {
		return "Cajero [turnoTrabajo=" + turnoTrabajo + "]";
	};
	
	
	
	

}
