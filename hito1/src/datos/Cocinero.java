package datos;

import java.time.LocalDate;

public class Cocinero extends Personal{
	
	private String especialidadCulinaria;
	private float plus;
	
	public Cocinero() {}

	

	public Cocinero(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, LocalDate fechaIngreso,
			float sueldoBase, String especialidadCulinaria, float plus) {
		super(nombre, apellido, dni, fechaDeNacimiento, fechaIngreso, sueldoBase);
		this.especialidadCulinaria = especialidadCulinaria;
		this.plus = plus;
	}



	public String getEspecialidadCulinaria() {
		return especialidadCulinaria;
	}

	public void setEspecialidadCulinaria(String especialidadCulinaria) {
		this.especialidadCulinaria = especialidadCulinaria;
	}

	public float getPlus() {
		return plus;
	}

	public void setPlus(float plus) {
		this.plus = plus;
	}

	@Override
	public String toString() {
		return "Cocinero [especialidadCulinaria=" + especialidadCulinaria + ", plus=" + plus + "]";
	};
	
	

}
