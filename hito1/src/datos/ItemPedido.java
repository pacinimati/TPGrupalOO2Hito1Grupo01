package datos;

public class ItemPedido {
	private long id;
	private Plato plato;
	private int cantidad;
	
	public ItemPedido() {}

	public ItemPedido(Plato plato, int cantidad) {
		super();
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	};
	
	
	
}
