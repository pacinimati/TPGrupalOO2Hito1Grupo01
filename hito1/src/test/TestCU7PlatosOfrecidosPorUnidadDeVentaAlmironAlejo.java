package test;

import java.util.Set;

import datos.Plato;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestCU7PlatosOfrecidosPorUnidadDeVentaAlmironAlejo {

    public static void main(String[] args) {
        UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
        long idBuscado = 1L;

        System.out.println("=================================================");
        System.out.println("  CU 7: PLATOS OFRECIDOS POR UNIDAD DE VENTA - AlmironAlejo");
        System.out.println("=================================================");

        try {
            UnidadVenta uv = unidadVentaAbm.traerConListas(idBuscado);

            System.out.println("Unidad: " + uv.getNombreComercial());
            System.out.println("Código único: " + uv.getCodigoUnico());
            System.out.println("Tipo: " + uv.getClass().getSimpleName());

            Set<Plato> platos = uv.getLstIPlatos();
            if (platos == null || platos.isEmpty()) {
                System.out.println("La unidad no tiene platos ofrecidos.");
            } else {
                System.out.println("Platos ofrecidos:");
                for (Plato plato : platos) {
                    System.out.println("- " + plato.getNombre()
                            + " | Precio de venta: $" + plato.getPrecioVenta());
                }
            }

        } catch (Exception e) {
            System.out.println("Error en el caso de uso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
