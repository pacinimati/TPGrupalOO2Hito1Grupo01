package datos;

import java.time.LocalDate;

public abstract class Personal {
	
	private long id;
	private String nombre;
	private String apellido;
	private int dni;
	private LocalDate fechaDeNacimiento;
	private LocalDate fechaIngreso;
	private float sueldoBase;
	
	public Personal() {}

	public Personal(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, LocalDate fechaIngreso,
			float sueldoBase) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.sueldoBase = sueldoBase;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}



	@Override
	public String toString() {
		return "Personal [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", fechaIngreso=" + fechaIngreso + ", sueldoBase="
				+ sueldoBase;
	};
	
	
	
	

}
