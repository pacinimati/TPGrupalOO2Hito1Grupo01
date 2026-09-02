package test;

import datos.Personal;
import java.util.List;
import negocio.PersonalABM;

public class TestCU9CostoSueldosFestivalRodrigoFernandez {
public static void main(String[] args) {
        PersonalABM personalAbm = new PersonalABM();
        long idFestivalBuscado = 1; // "Lollapalooza 2026"

        try {
            // Consultas
            List<Personal> staff = personalAbm.traerPersonalPorFestival(idFestivalBuscado);
            float totalSueldos = personalAbm.calcularCostoSueldosFestival(idFestivalBuscado);

            // Impresion
            System.out.println("=================================================");
            System.out.println("  CASO DE USO 9: COSTO DE SUELDOS DE UN FESTIVAL ");
            System.out.println("=================================================");
            for (Personal p : staff) {
                System.out.println("- " + p.getNombre() + " " + p.getApellido()
                        + " (" + p.getClass().getSimpleName() + ") - Sueldo base: $" + p.getSueldoBase());
            }
            System.out.println("-------------------------------------------------");
            System.out.println("COSTO TOTAL DE SUELDOS: $" + totalSueldos);
            System.out.println("=================================================");

        } catch (Exception e) {
            System.out.println("Error en la ejecución del Caso de Uso: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
