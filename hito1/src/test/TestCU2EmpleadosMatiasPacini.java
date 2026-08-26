package test;

import negocio.UnidadVentaABM;

public class TestCU2EmpleadosMatiasPacini {

    public static void main(String[] args) {
        UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
        long idBuscado = 1; 

        try {
            System.out.println("=================================================");
            System.out.println("  CASO DE USO: TRAER EMPLEADOS POR UNIDAD VENTA  ");
            System.out.println("=================================================");

            unidadVentaAbm.traerEmpleadosPorUnidad(idBuscado);

            System.out.println("=================================================");

        } catch (Exception e) {
            System.out.println("Error en el test: " + e.getMessage());
            e.printStackTrace();
        }
    }
}