package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import dao.PedidoDao;
import datos.ItemPedido;
import datos.Pedido;
import datos.UnidadVenta;

public class PedidoABM {
	private PedidoDao dao = new PedidoDao();

	public Pedido traer(long idPedido) {
		return dao.traer(idPedido);
	}

	public Pedido traerConItems(long idPedido) {
		return dao.traerConItems(idPedido);
	}

	public long agregar(LocalDate fechaTransaccion, UnidadVenta unidadVenta, Set<ItemPedido> lstItems) throws Exception {
		if (unidadVenta == null) {
			throw new Exception("Error: El pedido debe pertenecer a una UnidadVenta existente.");
		}
		Pedido p = new Pedido(fechaTransaccion, unidadVenta, lstItems);
		return dao.agregar(p);
	}

	public void modificar(Pedido p) {
		dao.actualizar(p);
	}

	public void eliminar(long idPedido) throws Exception {
		Pedido p = dao.traer(idPedido);
		if (p == null) {
			throw new Exception("Error: El pedido solicitado no existe.");
		}
		dao.eliminar(p);
	}

	public List<Pedido> traer() {
		return dao.traer();
	}
}