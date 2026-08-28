package test;

import dao.PedidoDao;
import datos.Pedido;

public class TestCU5TraerUltimoPedidoRodrigoMercado {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		PedidoDao pedidoDao = new PedidoDao();
		Pedido ultimo = pedidoDao.traerUltimoPedido();
		
        System.out.println("==================================================");
        System.out.println("  CASO DE USO 5: TRAER EL ULTIMO PEDIDO REALIZADO ");
        System.out.println("==================================================");

		if (ultimo != null) {
			System.out.println("ID Pedido: " + ultimo.getId());
			System.out.println("Fecha de Transacción: " + ultimo.getFechaTransaccion());
		} else {
			System.out.println("No hay pedidos registrados en la base de datos.");
		}
	}

}
