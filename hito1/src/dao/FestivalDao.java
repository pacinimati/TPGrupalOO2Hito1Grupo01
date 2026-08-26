package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.Festival;

public class FestivalDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		if (tx != null) {
			tx.rollback();
		}
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public long agregar(Festival objeto) {
		long id = 0;
		try {
			iniciaOperacion();
			id = Long.parseLong(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return id;
	}

	public void actualizar(Festival objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void eliminar(Festival objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public Festival traer(long idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = session.get(Festival.class, idFestival);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objeto;
	}

	public Festival traer(String nombre) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = session.createQuery("from Festival f where f.nombre = :nombre", Festival.class)
					.setParameter("nombre", nombre)
					.uniqueResult();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objeto;
	}

	public List<Festival> traer() {
		List<Festival> lista = new ArrayList<>();
		try {
			iniciaOperacion();
			Query<Festival> query = session.createQuery("from Festival f order by f.nombre asc", Festival.class);
			lista = query.getResultList();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return lista;
	}

	// Trae el festival junto con su lista de unidades de venta (FETCH para evitar LazyInitializationException)
	public Festival traerFestivalConUnidades(long idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = session.createQuery("from Festival f left join fetch f.lstUnidadVenta where f.id = :idFestival", Festival.class)
					.setParameter("idFestival", idFestival)
					.uniqueResult();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return objeto;
	}
}