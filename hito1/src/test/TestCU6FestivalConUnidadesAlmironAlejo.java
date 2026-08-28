package test;

import java.util.Set;

import datos.Festival;
import datos.UnidadVenta;
import negocio.FestivalABM;

public class TestCU6FestivalConUnidadesAlmironAlejo {

    public static void main(String[] args) {
        FestivalABM festivalAbm = new FestivalABM();

        System.out.println("=================================================");
        System.out.println("  CU 6: FESTIVAL CON UNIDADES - AlmironAlejo");
        System.out.println("=================================================");

        try {
            Festival festival = festivalAbm.traerFestivalConUnidades(1L);

            if (festival == null) {
                System.out.println("No existe un festival con ese ID.");
                return;
            }

            System.out.println("Festival: " + festival.getNombre());
            System.out.println("Temporada: " + festival.getTemporada());
            System.out.println("Fechas: " + festival.getFechaInicio() + " - " + festival.getFechaFin());

            Set<UnidadVenta> unidades = festival.getLstUnidadVenta();
            if (unidades == null || unidades.isEmpty()) {
                System.out.println("El festival no tiene unidades de venta asociadas.");
            } else {
                System.out.println("Unidades vinculadas:");
                for (UnidadVenta uv : unidades) {
                    System.out.println("- " + uv.getNombreComercial()
                            + " | Código: " + uv.getCodigoUnico()
                            + " | Tipo: " + uv.getClass().getSimpleName());
                }
            }

        } catch (Exception e) {
            System.out.println("Error en el caso de uso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
