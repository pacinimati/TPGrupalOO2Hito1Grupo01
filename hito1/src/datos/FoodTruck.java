package datos;

import java.util.Set;

public class FoodTruck extends UnidadVenta{
	
	private String patente;
	private boolean conexionElectrica;
	
	public FoodTruck() {}

	
	public FoodTruck(String nombreComercial, Personal responsable, float superficieM2, String codigoUnico,
			Festival festival, Set<Plato> lstIPlatos, Set<Personal> lstIPersonal, String patente,
			boolean conexionElectrica) {
		super(nombreComercial, responsable, superficieM2, codigoUnico, festival, lstIPlatos, lstIPersonal);
		this.patente = patente;
		this.conexionElectrica = conexionElectrica;
	}


	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean isConexionElectrica() {
		return conexionElectrica;
	}

	public void setConexionElectrica(boolean conexionElectrica) {
		this.conexionElectrica = conexionElectrica;
	}

	@Override
	public String toString() {
		return "FoodTruck [patente=" + patente + ", conexionElectrica=" + conexionElectrica + "]";
	};
	
	

}
