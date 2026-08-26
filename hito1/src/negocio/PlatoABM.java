package negocio;

import java.util.List;
import dao.PlatoDao;
import datos.Plato;

public class PlatoABM {
	private PlatoDao dao = new PlatoDao();

	public Plato traer(long idPlato) {
		return dao.traer(idPlato);
	}

	public Plato traer(String nombre) {
		return dao.traer(nombre);
	}

	public long agregar(String nombre, float precioVenta, float costoProduccion) throws Exception {
		if (dao.traer(nombre) != null) {
			throw new Exception("Error: Ya existe un plato con el nombre " + nombre);
		}
		Plato p = new Plato(nombre, precioVenta, costoProduccion);
		return dao.agregar(p);
	}

	public void modificar(Plato p) throws Exception {
		Plato existente = dao.traer(p.getNombre());
		if (existente != null && existente.getId() != p.getId()) {
			throw new Exception("Error: Ya existe otro plato con el nombre " + p.getNombre());
		}
		dao.actualizar(p);
	}

	public void eliminar(long idPlato) throws Exception {
		Plato p = dao.traer(idPlato);
		if (p == null) {
			throw new Exception("Error: El plato no existe.");
		}
		dao.eliminar(p);
	}

	public List<Plato> traer() {
		return dao.traer();
	}
}