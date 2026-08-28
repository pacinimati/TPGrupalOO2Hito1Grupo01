package test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import negocio.PedidoABM;
import negocio.PlatoABM;
import negocio.UnidadVentaABM;
import datos.ItemPedido;
import datos.Plato;
import datos.UnidadVenta;

public class TestAgregarPedido {

    public static void main(String[] args) {
        PedidoABM pedidoAbm = new PedidoABM();
        UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
        PlatoABM platoAbm = new PlatoABM();

        try {
            System.out.println("=== TEST: AGREGAR PEDIDO CON ITEMS ===");

            UnidadVenta uv = unidadVentaAbm.traer("FT-001");
            Plato plato = platoAbm.traer("Burger Completa");

            if (uv == null || plato == null) {
                System.out.println("Aviso: Primero debés ejecutar los tests de UnidadVenta y Plato.");
                return;
            }

            // Armamos la lista de items (gracias a cascade="all" en Pedido.hbm.xml, los items se guardan solos)
            Set<ItemPedido> items = new HashSet<>();
            ItemPedido item1 = new ItemPedido(plato, 2);
            items.add(item1);

            long idPedido = pedidoAbm.agregar(LocalDate.now(), uv, items);
            System.out.println("-> Pedido registrado con éxito (con sus ítems). ID: " + idPedido);

        } catch (Exception e) {
            System.out.println("Error en test Pedido: " + e.getMessage());
        }
    }
}