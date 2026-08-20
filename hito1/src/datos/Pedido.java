package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {
	
	private long id;
	private LocalDate fechaTransaccion;
	private UnidadVenta unidadVenta;
	private Set<ItemPedido> lstItems; 
	
	public Pedido() {}

	public Pedido(LocalDate fechaTransaccion, Set<ItemPedido> lstItems) {
		super();
		this.fechaTransaccion = fechaTransaccion;
		this.lstItems = lstItems;
	}

	public Pedido(LocalDate fechaTransaccion, UnidadVenta unidadVenta, Set<ItemPedido> lstItems) {
		super();
		this.fechaTransaccion = fechaTransaccion;
		this.unidadVenta = unidadVenta;
		this.lstItems = lstItems;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public Set<ItemPedido> getLstItems() {
		return lstItems;
	}

	public void setLstItems(Set<ItemPedido> lstItems) {
		this.lstItems = lstItems;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fechaTransaccion=" + fechaTransaccion + ", unidadVenta=" + unidadVenta
				+ ", lstItems=" + lstItems + "]";
	};
	
	
	
	
	

}
