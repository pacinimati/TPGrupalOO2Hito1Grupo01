package test;
import java.util.List;
import negocio.PedidoABM;
import datos.FoodTruck;
public class TestCU8PlatoMasVendidoRodrigoFernandez {
public static void main(String[] args) {

        PedidoABM pedidoAbm = new PedidoABM();

        try {
            List<Object[]> resultado = pedidoAbm.platoMasVendidoPorTipoUnidad(FoodTruck.class);
            System.out.println("=================================================");
            System.out.println("  CASO DE USO 8: PLATO MÁS VENDIDO POR TIPO DE UNIDAD ");
            System.out.println("=================================================");
            for (Object[] fila : resultado) {
                String nombrePlato = (String) fila[0];
                Long totalVendido = (Long) fila[1];
                System.out.println("Plato: " + nombrePlato + " - Cantidad vendida: " + totalVendido);
            }
            System.out.println("=================================================");

        } catch (Exception e) {
            System.out.println("Error en la ejecución del Caso de Uso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}