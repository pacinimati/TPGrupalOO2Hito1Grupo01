package datos;

import java.time.LocalDate;
import java.util.Set;

public class Festival {
	
	private long id;
    private String nombre;
    private String temporada;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private float costoPorSuperficie;
    private float costoPorMontaje;
    private float plusUsoElectricidad;
    private float sueldoBase;
    
    private Set<Personal> lstPersonal;
    private Set<UnidadVenta> lstUnidadVenta;
    
    public Festival() {}

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
			float costoPorSuperficie, float costoPorMontaje, float plusUsoElectricidad, float sueldoBase,
			Set<Personal> lstPersonal, Set<UnidadVenta> lstUnidadVenta) {
		super();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costoPorSuperficie = costoPorSuperficie;
		this.costoPorMontaje = costoPorMontaje;
		this.plusUsoElectricidad = plusUsoElectricidad;
		this.sueldoBase = sueldoBase;
		this.lstPersonal = lstPersonal;
		this.lstUnidadVenta = lstUnidadVenta;
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

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getCostoPorSuperficie() {
		return costoPorSuperficie;
	}

	public void setCostoPorSuperficie(float costoPorSuperficie) {
		this.costoPorSuperficie = costoPorSuperficie;
	}

	public float getCostoPorMontaje() {
		return costoPorMontaje;
	}

	public void setCostoPorMontaje(float costoPorMontaje) {
		this.costoPorMontaje = costoPorMontaje;
	}

	public float getPlusUsoElectricidad() {
		return plusUsoElectricidad;
	}

	public void setPlusUsoElectricidad(float plusUsoElectricidad) {
		this.plusUsoElectricidad = plusUsoElectricidad;
	}

	public float getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Set<Personal> getLstPersonal() {
		return lstPersonal;
	}

	public void setLstPersonal(Set<Personal> lstPersonal) {
		this.lstPersonal = lstPersonal;
	}

	public Set<UnidadVenta> getLstUnidadVenta() {
		return lstUnidadVenta;
	}

	public void setLstUnidadVenta(Set<UnidadVenta> lstUnidadVenta) {
		this.lstUnidadVenta = lstUnidadVenta;
	}

	@Override
	public String toString() {
		return "Festival [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", costoPorSuperficie=" + costoPorSuperficie + ", costoPorMontaje="
				+ costoPorMontaje + ", plusUsoElectricidad=" + plusUsoElectricidad + ", sueldoBase=" + sueldoBase
				+ ", lstPersonal=" + lstPersonal + ", lstUnidadVenta=" + lstUnidadVenta + "]";
	};
	
	
    
    
    
    
}
