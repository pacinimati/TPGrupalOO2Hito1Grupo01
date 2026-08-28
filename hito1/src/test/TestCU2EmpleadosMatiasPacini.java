package test;

import negocio.UnidadVentaABM;
import datos.UnidadVenta;
import datos.Personal;
import datos.Cocinero;
import datos.Cajero;

public class TestCU2EmpleadosMatiasPacini {

    public static void main(String[] args) {
        UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
        long idBuscado = 1; 

        try {
            System.out.println("=================================================");
            System.out.println("  CASO DE USO: TRAER EMPLEADOS POR UNIDAD VENTA  ");
            System.out.println("=================================================");

            // 1. Recibimos la UnidadVenta recuperada desde la capa de Negocio (ABM)
            UnidadVenta uv = unidadVentaAbm.traerEmpleadosPorUnidad(idBuscado);

            System.out.println("Puesto: " + uv.getNombreComercial());
            System.out.println("Código Único: " + uv.getCodigoUnico());
            System.out.println("-------------------------------------------------");

            // 2. Iteramos e imprimimos la lista de personal recuperada con JOIN FETCH
            if (uv.getLstIPersonal() == null || uv.getLstIPersonal().isEmpty()) {
                System.out.println("No hay empleados asignados a esta unidad.");
            } else {
                for (Personal p : uv.getLstIPersonal()) {
                    String cargo = (p instanceof Cocinero) ? "Cocinero" : 
                                   (p instanceof Cajero) ? "Cajero" : "Personal General";

                    System.out.println("- " + p.getApellido() + ", " + p.getNombre() 
                            + " [DNI: " + p.getDni() + "] | Cargo: " + cargo);
                }
            }

            System.out.println("=================================================");

        } catch (Exception e) {
            System.out.println("Error en el test: " + e.getMessage());
            e.printStackTrace();
        }
    }
}