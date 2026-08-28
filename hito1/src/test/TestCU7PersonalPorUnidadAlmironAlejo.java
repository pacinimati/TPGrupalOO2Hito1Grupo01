package test;

import java.util.Set;

import datos.Personal;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestCU7PersonalPorUnidadAlmironAlejo {

    public static void main(String[] args) {
        UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
        long idBuscado = 1L;

        System.out.println("=================================================");
        System.out.println("  CU 7: PERSONAL ASIGNADO POR UNIDAD - AlmironAlejo");
        System.out.println("=================================================");

        try {
            UnidadVenta uv = unidadVentaAbm.traerEmpleadosPorUnidad(idBuscado);

            System.out.println("Unidad: " + uv.getNombreComercial());
            System.out.println("Código único: " + uv.getCodigoUnico());
            System.out.println("Tipo: " + uv.getClass().getSimpleName());

            Set<Personal> personal = uv.getLstIPersonal();
            if (personal == null || personal.isEmpty()) {
                System.out.println("La unidad no tiene personal asignado.");
            } else {
                System.out.println("Personal asignado:");
                for (Personal p : personal) {
                    System.out.println("- " + p.getNombre() + " " + p.getApellido()
                            + " | DNI: " + p.getDni()
                            + " | Rol: " + p.getClass().getSimpleName());
                }
            }

        } catch (Exception e) {
            System.out.println("Error en el caso de uso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
