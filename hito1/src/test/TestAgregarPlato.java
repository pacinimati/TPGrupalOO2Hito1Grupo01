package test;

import negocio.PlatoABM;

public class TestAgregarPlato {

    public static void main(String[] args) {
        PlatoABM platoAbm = new PlatoABM();

        try {
            System.out.println("=== TEST: AGREGAR PLATO ===");

            long idPlato1 = platoAbm.agregar("Burger Completa", 8500.00f, 3200.00f);
            System.out.println("-> Plato 'Burger Completa' creado con ID: " + idPlato1);

            long idPlato2 = platoAbm.agregar("Papas Rusticas", 4000.00f, 1200.00f);
            System.out.println("-> Plato 'Papas Rusticas' creado con ID: " + idPlato2);

        } catch (Exception e) {
            System.out.println("Error en test Plato: " + e.getMessage());
        }
    }
}