package negocio;


import datos.Cajero;
import datos.Cocinero;
import dao.PedidoDao;
import datos.ItemPedido;
import datos.Pedido;

import java.util.List;
import java.util.Set;
import dao.UnidadVentaDao;
import datos.Festival;

import datos.FoodTruck;
import datos.Personal;
import datos.Plato;

import datos.PuestoDesarmable;
import datos.UnidadVenta;

public class UnidadVentaABM {
	private UnidadVentaDao dao = new UnidadVentaDao();

	public UnidadVenta traer(long idUnidadVenta) {
		return dao.traer(idUnidadVenta);
	}

	public UnidadVenta traer(String codigoUnico) {
		return dao.traer(codigoUnico);
	}

	public UnidadVenta traerConListas(long idUnidadVenta) {
		return dao.traerConListas(idUnidadVenta);
	}

	public long agregarFoodTruck(String nombreComercial, Personal responsable, float superficieM2,
			String codigoUnico, Festival festival, Set<Plato> lstIPlatos, Set<Personal> lstIPersonal,
			String patente, boolean conexionElectrica) throws Exception {
		if (dao.traer(codigoUnico) != null) {
			throw new Exception("Error: Ya existe una UnidadVenta con el código " + codigoUnico);
		}
		FoodTruck ft = new FoodTruck(nombreComercial, responsable, superficieM2, codigoUnico, festival,
				lstIPlatos, lstIPersonal, patente, conexionElectrica);
		return dao.agregar(ft);
	}

	public long agregarPuestoDesarmable(String nombreComercial, Personal responsable, float superficieM2,
			String codigoUnico, Festival festival, Set<Plato> lstIPlatos, Set<Personal> lstIPersonal,
			int carpasComponen, int tiempoMontaje) throws Exception {
		if (dao.traer(codigoUnico) != null) {
			throw new Exception("Error: Ya existe una UnidadVenta con el código " + codigoUnico);
		}
		PuestoDesarmable pd = new PuestoDesarmable(nombreComercial, responsable, superficieM2, codigoUnico, festival,
				lstIPlatos, lstIPersonal, carpasComponen, tiempoMontaje);
		return dao.agregar(pd);
	}

	public void modificar(UnidadVenta u) throws Exception {
		UnidadVenta existente = dao.traer(u.getCodigoUnico());
		if (existente != null && existente.getId() != u.getId()) {
			throw new Exception("Error: Ya existe otra UnidadVenta con el código " + u.getCodigoUnico());
		}
		dao.actualizar(u);
	}

	public void eliminar(long idUnidadVenta) throws Exception {
		UnidadVenta u = dao.traer(idUnidadVenta);
		if (u == null) {
			throw new Exception("Error: La UnidadVenta solicitada no existe.");
		}
		dao.eliminar(u);
	}

	public List<UnidadVenta> traer() {
		return dao.traer();
	}
	
	
	// 1. Invoca la recaudación del DAO con validación previa
    public float calcularRecaudacionTotal(String codigoUnico) throws Exception {
        UnidadVenta uv = dao.traer(codigoUnico);
        if (uv == null) {
            throw new Exception("Error: No existe la Unidad de Venta con código " + codigoUnico);
        }
        return dao.calcularRecaudacionTotal(codigoUnico);
    }

    // 2. Invoca el traerConListas del DAO con validación previa
    public UnidadVenta traerEmpleadosPorUnidad(long idUnidadVenta) throws Exception {
        UnidadVenta uv = dao.traerConListas(idUnidadVenta);
        if (uv == null) {
            throw new Exception("Error: No existe la Unidad de Venta con ID " + idUnidadVenta);
        }
        return uv;
    }
}