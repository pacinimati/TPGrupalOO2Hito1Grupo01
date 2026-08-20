package datos;

public class Plato {
	private long idPlato;
	private String nombre; 
	private float precioVenta;
	private float costoProduccion;
	
	public Plato() {}

	public Plato(String nombre, float precioVenta, float costoProduccion) {
		super();
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
	}

	public long getIdPlato() {
		return idPlato;
	}

	protected void setIdPlato(long idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public float getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precioVenta=" + precioVenta
				+ ", costoProduccion=" + costoProduccion + "]";
	};
	
	
	
	
	
	
}
