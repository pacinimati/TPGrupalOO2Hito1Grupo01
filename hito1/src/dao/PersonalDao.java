package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.Personal;

public class PersonalDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		if (tx != null) tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public long agregar(Personal objeto) {
		long id = 0;
		try {
			iniciaOperacion();
			id = Long.parseLong(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return id;
	}

	public void actualizar(Personal objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
	}

	public void eliminar(Personal objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
	}

	public Personal traer(long idPersonal) {
		Personal objeto = null;
		try {
			iniciaOperacion();
			objeto = session.get(Personal.class, idPersonal);
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return objeto;
	}

	public Personal traer(int dni) {
		Personal p = null;
		try {
			iniciaOperacion();
			p = session.createQuery("from Personal p where p.dni = :dni", Personal.class)
					.setParameter("dni", dni)
					.uniqueResult();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return p;
	}

	public List<Personal> traer() {
		List<Personal> lista = new ArrayList<>();
		try {
			iniciaOperacion();
			Query<Personal> query = session.createQuery("from Personal p order by p.apellido asc, p.nombre asc", Personal.class);
			lista = query.getResultList();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return lista;
	}

	public List<Personal> traerPersonalPorFestival(long idFestival) {
    	List<Personal> lista = new ArrayList<Personal>();
    try {
        iniciaOperacion();
        String hql = "select distinct per from UnidadVenta uv join uv.lstIPersonal per where uv.festival.id = :idFestival";
        lista = session.createQuery(hql, Personal.class)
                       .setParameter("idFestival", idFestival)
                       .getResultList();
    } finally {
        session.close();
    }
    	return lista;
	}
}