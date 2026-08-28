package datos;

import java.util.Set;

public class PuestoDesarmable extends UnidadVenta{
	
	private int carpasComponen;
	private int tiempoMontaje;
	
	public PuestoDesarmable() {}

	public PuestoDesarmable(String nombreComercial, Personal responsable, float superficieM2, String codigoUnico,
			Festival festival, Set<Plato> lstIPlatos, Set<Personal> lstIPersonal, int carpasComponen,
			int tiempoMontaje) {
		super(nombreComercial, responsable, superficieM2, codigoUnico, festival, lstIPlatos, lstIPersonal);
		this.carpasComponen = carpasComponen;
		this.tiempoMontaje = tiempoMontaje;
	}

	public int getCarpasComponen() {
		return carpasComponen;
	}

	public void setCarpasComponen(int carpasComponen) {
		this.carpasComponen = carpasComponen;
	}

	public int getTiempoMontaje() {
		return tiempoMontaje;
	}

	public void setTiempoMontaje(int tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}

	@Override
	public String toString() {
		return "PuestoDesarmable [carpasComponen=" + carpasComponen + ", tiempoMontaje=" + tiempoMontaje + "]";
	};
	
	
	
	

}
