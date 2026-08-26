package test;

import java.time.LocalDate;
import negocio.FestivalABM;

public class TestAgregarFestival {

    public static void main(String[] args) {
        FestivalABM festivalAbm = new FestivalABM();

        try {
            System.out.println("=== TEST 1: AGREGAR FESTIVAL ===");
            
            // Intento de alta exitoso
            long id1 = festivalAbm.agregar("Lollapalooza 2026", "Primavera", LocalDate.of(2026, 9, 15), 
                    LocalDate.of(2026, 9, 18), 1500.50f, 3000.00f, 500.00f, 120000.00f);
            System.out.println("-> Festival 'Lollapalooza 2026' guardado correctamente con ID: " + id1);

            long id2 = festivalAbm.agregar("Cosquín Rock 2027", "Verano", LocalDate.of(2027, 2, 10), 
                    LocalDate.of(2027, 2, 12), 1200.00f, 2500.00f, 400.00f, 100000.00f);
            System.out.println("-> Festival 'Cosquín Rock 2027' guardado correctamente con ID: " + id2);

            System.out.println("\n--- Prueba de validación de duplicados ---");
            // Intento de alta duplicado (debe capturar la excepción)
            festivalAbm.agregar("Lollapalooza 2026", "Verano", LocalDate.of(2026, 10, 1), 
                    LocalDate.of(2026, 10, 3), 1000f, 2000f, 300f, 90000f);

        } catch (Exception e) {
            System.out.println("Excepción capturada esperada: " + e.getMessage());
        }
    }
}