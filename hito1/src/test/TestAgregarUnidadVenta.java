package test;

import negocio.FestivalABM;
import negocio.PersonalABM;
import negocio.UnidadVentaABM;
import datos.Festival;
import datos.Personal;

public class TestAgregarUnidadVenta {

    public static void main(String[] args) {
        UnidadVentaABM unidadVentaAbm = new UnidadVentaABM();
        FestivalABM festivalAbm = new FestivalABM();
        PersonalABM personalAbm = new PersonalABM();

        try {
            System.out.println("=== TEST: AGREGAR FOODTRUCK Y PUESTO DESARMABLE ===");

            // Obtenemos dependencias requeridas
            Festival festival = festivalAbm.traer("Lollapalooza 2026");
            Personal responsable = personalAbm.traer(30111222); // DNI cargado previamente

            if (festival == null || responsable == null) {
                System.out.println("Aviso: Primero debés ejecutar los tests de Festival y Personal para asociarlos.");
                return;
            }

            // 1. Alta de FoodTruck
            long idFT = unidadVentaAbm.agregarFoodTruck(
                "La Burgeria Truck", responsable, 25.5f, "FT-001", 
                festival, null, null, "AB123CD", true
            );
            System.out.println("-> FoodTruck guardado con éxito. ID: " + idFT);

            // 2. Alta de PuestoDesarmable
            long idPD = unidadVentaAbm.agregarPuestoDesarmable(
                "Stand Papas & Co", responsable, 12.0f, "PD-001", 
                festival, null, null, 2, 45
            );
            System.out.println("-> PuestoDesarmable guardado con éxito. ID: " + idPD);

        } catch (Exception e) {
            System.out.println("Error en test UnidadVenta: " + e.getMessage());
        }
    }
}