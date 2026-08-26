package test;

import java.time.LocalDate;
import negocio.PersonalABM;

public class TestAgregarPersonal {

    public static void main(String[] args) {
        PersonalABM personalAbm = new PersonalABM();

        try {
            System.out.println("=== TEST: AGREGAR COCINERO Y CAJERO ===");

            // 1. Alta de Cocinero
            long idCocinero = personalAbm.agregarCocinero(
                "Gordon", "Ramsay", 30111222, 
                LocalDate.of(1985, 5, 20), LocalDate.of(2024, 1, 15), 
                180000.00f, "Parrilla y Ahogados", 25000.00f
            );
            System.out.println("-> Cocinero guardado con éxito. ID: " + idCocinero);

            // 2. Alta de Cajero
            long idCajero = personalAbm.agregarCajero(
                "Laura", "Gómez", 35333444, 
                LocalDate.of(1992, 8, 10), LocalDate.of(2024, 3, 1), 
                150000.00f, "Noche"
            );
            System.out.println("-> Cajero guardado con éxito. ID: " + idCajero);

        } catch (Exception e) {
            System.out.println("Error en test Personal: " + e.getMessage());
        }
    }
}