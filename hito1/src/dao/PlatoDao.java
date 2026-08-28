package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.Plato;

public class PlatoDao {
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

	public long agregar(Plato objeto) {
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

	public void actualizar(Plato objeto) {
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

	public void eliminar(Plato objeto) {
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

	public Plato traer(long idPlato) {
		Plato objeto = null;
		try {
			iniciaOperacion();
			objeto = session.get(Plato.class, idPlato);
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return objeto;
	}

	public Plato traer(String nombre) {
		Plato p = null;
		try {
			iniciaOperacion();
			p = session.createQuery("from Plato p where p.nombre = :nombre", Plato.class)
					.setParameter("nombre", nombre)
					.uniqueResult();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return p;
	}

	public List<Plato> traer() {
		List<Plato> lista = new ArrayList<>();
		try {
			iniciaOperacion();
			Query<Plato> query = session.createQuery("from Plato p order by p.nombre asc", Plato.class);
			lista = query.getResultList();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return lista;
	}
	
	public List<Plato> traerPorPrecioMenorA(float precio) {
	    List<Plato> lista = new ArrayList<>();
	    try {
	        iniciaOperacion();
	        lista = session.createQuery("from Plato p where p.precioVenta < :precio order by p.precioVenta asc", Plato.class)
	                .setParameter("precio", precio)
	                .getResultList();
	    } catch (HibernateException he) {
	        manejaExcepcion(he);
	    } finally {
	        if (session != null && session.isOpen()) session.close();
	    }
	    return lista;
	}
}
