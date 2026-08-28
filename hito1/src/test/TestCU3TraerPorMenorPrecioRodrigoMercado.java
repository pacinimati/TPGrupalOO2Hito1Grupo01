package test;

import java.util.List;

import dao.PlatoDao;
import datos.Plato;

public class TestCU3TraerPorMenorPrecioRodrigoMercado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PlatoDao dao = new PlatoDao();
		float precio = 5000;
		
		List<Plato> lista = dao.traerPorPrecioMenorA(precio);
		
        System.out.println("=================================================");
        System.out.println("  CASO DE USO 3: TRAER PLATOS MENORES A $" + precio);
        System.out.println("=================================================");
        
        try {
            for (Plato p : lista) {
                System.out.println(p.getNombre() + " - " + p.getPrecioVenta());
            }
		} catch (Exception e) {
            System.out.println("Error en el test: " + e.getMessage());
            e.printStackTrace();
		}
	}

}
