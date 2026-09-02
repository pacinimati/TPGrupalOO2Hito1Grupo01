package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.PersonalDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Personal;

public class PersonalABM {
	private PersonalDao dao = new PersonalDao();

	public Personal traer(long idPersonal) {
		return dao.traer(idPersonal);
	}

	public Personal traer(int dni) {
		return dao.traer(dni);
	}

	public long agregarCocinero(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento,
			LocalDate fechaIngreso, float sueldoBase, String especialidadCulinaria, float plus) throws Exception {
		if (dao.traer(dni) != null) {
			throw new Exception("Error: Ya existe un personal registrado con DNI " + dni);
		}
		Cocinero c = new Cocinero(nombre, apellido, dni, fechaDeNacimiento, fechaIngreso, sueldoBase, especialidadCulinaria, plus);
		return dao.agregar(c);
	}

	public long agregarCajero(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento,
			LocalDate fechaIngreso, float sueldoBase, String turnoTrabajo) throws Exception {
		if (dao.traer(dni) != null) {
			throw new Exception("Error: Ya existe un personal registrado con DNI " + dni);
		}
		Cajero c = new Cajero(nombre, apellido, dni, fechaDeNacimiento, fechaIngreso, sueldoBase, turnoTrabajo);
		return dao.agregar(c);
	}

	public void modificar(Personal p) throws Exception {
		Personal existente = dao.traer(p.getDni());
		if (existente != null && existente.getId() != p.getId()) {
			throw new Exception("Error: Ya existe otro registro con el DNI " + p.getDni());
		}
		dao.actualizar(p);
	}

	public void eliminar(long idPersonal) throws Exception {
		Personal p = dao.traer(idPersonal);
		if (p == null) {
			throw new Exception("Error: El personal solicitado no existe.");
		}
		dao.eliminar(p);
	}

	public List<Personal> traer() {
		return dao.traer();
	}

	public float calcularCostoSueldosFestival(long idFestival) throws Exception {
    	List<Personal> staff = dao.traerPersonalPorFestival(idFestival);
    	if (staff == null || staff.isEmpty()) {
        	throw new Exception("Error: no hay personal asociado al Festival con id " + idFestival);
    	}
    	float total = 0f;
    	for (Personal p : staff) {
        	total += p.getSueldoBase();
        if (p instanceof Cocinero) {
            total += ((Cocinero) p).getPlus();
        }
    	}
    	return total;
	}

	public List<Personal> traerPersonalPorFestival(long idFestival) {
    	return dao.traerPersonalPorFestival(idFestival);
	}
}