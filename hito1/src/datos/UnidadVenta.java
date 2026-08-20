package datos;

import java.util.Set;

public abstract class UnidadVenta {
	private long id;
	private String nombreComercial;
	private Personal responsable;
	private float superficieM2;
	private String codigoUnico;
	private Festival festival;
	private Set<Plato> lstIPlatos; 
	private Set<Personal> lstIPersonal;
	
	public UnidadVenta() {}

	public UnidadVenta(String nombreComercial, Personal responsable, float superficieM2, String codigoUnico,
			Festival festival, Set<Plato> lstIPlatos, Set<Personal> lstIPersonal) {
		super();
		this.nombreComercial = nombreComercial;
		this.responsable = responsable;
		this.superficieM2 = superficieM2;
		this.codigoUnico = codigoUnico;
		this.festival = festival;
		this.lstIPlatos = lstIPlatos;
		this.lstIPersonal = lstIPersonal;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Personal getResponsable() {
		return responsable;
	}

	public void setResponsable(Personal responsable) {
		this.responsable = responsable;
	}

	public float getSuperficieM2() {
		return superficieM2;
	}

	public void setSuperficieM2(float superficieM2) {
		this.superficieM2 = superficieM2;
	}

	public String getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public Set<Plato> getLstIPlatos() {
		return lstIPlatos;
	}

	public void setLstIPlatos(Set<Plato> lstIPlatos) {
		this.lstIPlatos = lstIPlatos;
	}

	public Set<Personal> getLstIPersonal() {
		return lstIPersonal;
	}

	public void setLstIPersonal(Set<Personal> lstIPersonal) {
		this.lstIPersonal = lstIPersonal;
	}

	@Override
	public String toString() {
		return "UnidadVenta [id=" + id + ", nombreComercial=" + nombreComercial + ", responsable=" + responsable
				+ ", superficieM2=" + superficieM2 + ", codigoUnico=" + codigoUnico + ", festival=" + festival
				+ ", lstIPlatos=" + lstIPlatos + ", lstIPersonal=" + lstIPersonal + "]";
	};
	
	
	
	
	

}
