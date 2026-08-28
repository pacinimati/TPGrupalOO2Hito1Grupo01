package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.FestivalDao;
import datos.Festival;

public class FestivalABM {
    private FestivalDao dao = new FestivalDao();

    public Festival traer(long idFestival) {
        return dao.traer(idFestival);
    }

    public Festival traer(String nombre) {
        return dao.traer(nombre);
    }

    public Festival traerFestivalConUnidades(long idFestival) {
        return dao.traerFestivalConUnidades(idFestival);
    }

    public long agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin,
            float costoPorSuperficie, float costoPorMontaje, float plusUsoElectricidad, float sueldoBase) throws Exception {
        
        // Valida que no exista un festival con el mismo nombre
        if (dao.traer(nombre) != null) {
            throw new Exception("Error: Ya existe un festival registrado con el nombre " + nombre);
        }

        Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin, costoPorSuperficie, 
                costoPorMontaje, plusUsoElectricidad, sueldoBase, null);
        
        return dao.agregar(f);
    }

    public void modificar(Festival f) throws Exception {
        Festival existente = dao.traer(f.getNombre());
        
        // Si cambió el nombre, valida que el nuevo nombre no esté en uso por otro registro
        if (existente != null && existente.getId() != f.getId()) {
            throw new Exception("Error: Ya existe otro festival con el nombre " + f.getNombre());
        }

        dao.actualizar(f);
    }

    public void eliminar(long idFestival) throws Exception {
        Festival f = dao.traerFestivalConUnidades(idFestival);
        
        if (f == null) {
            throw new Exception("Error: El festival con ID " + idFestival + " no existe.");
        }

        // Valida dependencias activas antes de realizar la baja física
        if (f.getLstUnidadVenta() != null && !f.getLstUnidadVenta().isEmpty()) {
            throw new Exception("Error: No se puede eliminar el festival porque tiene unidades de venta asociadas.");
        }

        dao.eliminar(f);
    }

    public List<Festival> traer() {
        return dao.traer();
    }
}