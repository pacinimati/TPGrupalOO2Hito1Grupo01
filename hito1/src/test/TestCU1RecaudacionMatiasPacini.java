package test;

import negocio.UnidadVentaABM;
import datos.UnidadVenta;

public class TestCU1RecaudacionMatiasPacini {

    public static void main(String[] args) {
        UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
        
        // Código de la Unidad de Venta a consultar (funciona tanto para FoodTruck como para PuestoDesarmable)
        String codigoBuscado = "FT-001"; 

        try {
            System.out.println("=================================================");
            System.out.println("   CASO DE USO 1: RECAUDACIÓN DE UNIDAD DE VENTA ");
            System.out.println("=================================================");

            // 1. Consultamos los datos de la Unidad de Venta
            UnidadVenta uv = unidadVentaAbm.traer(codigoBuscado);

            if (uv != null) {
                System.out.println("Puesto: " + uv.getNombreComercial());
                System.out.println("Código Único: " + uv.getCodigoUnico());
                System.out.println("Tipo de Entidad: " + uv.getClass().getSimpleName()); // Muestra 'FoodTruck' o 'PuestoDesarmable'

                // 2. Invocamos la lógica de negocio desde la capa ABM
                float totalRecaudado = unidadVentaAbm.calcularRecaudacionTotal(codigoBuscado);

                System.out.println("-------------------------------------------------");
                System.out.println("TOTAL RECAUDADO EN PEDIDOS: $" + totalRecaudado);
                System.out.println("=================================================");

            } else {
                System.out.println("Error: No se encontró la Unidad de Venta con código " + codigoBuscado);
            }

        } catch (Exception e) {
            System.out.println("Error en la ejecución del Caso de Uso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}