package test;

import java.util.List;

import dao.PedidoDao;
import dao.PlatoDao;
import datos.Pedido;
import datos.Plato;

public class TestCU4TraerPedidosPorPlatosRodrigoMercado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PedidoDao pedidoDao = new PedidoDao();
        PlatoDao platoDao = new PlatoDao();
        
        // 1. Buscamos el plato por nombre o ID
        Plato platoBuscado = platoDao.traer("Burger Completa");
        
        if (platoBuscado != null) {
            // 2. Traemos todos los pedidos donde se pidió ese plato
            List<Pedido> pedidos = pedidoDao.traerPorPlato(platoBuscado.getId());
            
            System.out.println("=======================================================");
            System.out.println("  CASO DE USO 4: PEDIDOS QUE CONTIENEN: " + platoBuscado.getNombre());
            System.out.println("=======================================================");
            
            for (Pedido p : pedidos) {
                System.out.println("Pedido ID: " + p.getId() + " - Fecha: " + p.getFechaTransaccion());
            }
        }
	}

}
