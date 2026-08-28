package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.UnidadVenta;

public class UnidadVentaDao {
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

	public long agregar(UnidadVenta objeto) {
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

	public void actualizar(UnidadVenta objeto) {
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

	public void eliminar(UnidadVenta objeto) {
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

	public UnidadVenta traer(long idUnidadVenta) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			objeto = session.get(UnidadVenta.class, idUnidadVenta);
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return objeto;
	}

	public UnidadVenta traer(String codigoUnico) {
		UnidadVenta u = null;
		try {
			iniciaOperacion();
			u = session.createQuery("from UnidadVenta u where u.codigoUnico = :codigoUnico", UnidadVenta.class)
					.setParameter("codigoUnico", codigoUnico)
					.uniqueResult();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return u;
	}

	public UnidadVenta traerConListas(long idUnidadVenta) {
		UnidadVenta u = null;
		try {
			iniciaOperacion();
			u = session.createQuery("from UnidadVenta u left join fetch u.lstIPlatos left join fetch u.lstIPersonal where u.id = :idUnidadVenta", UnidadVenta.class)
					.setParameter("idUnidadVenta", idUnidadVenta)
					.uniqueResult();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return u;
	}

	public List<UnidadVenta> traer() {
		List<UnidadVenta> lista = new ArrayList<>();
		try {
			iniciaOperacion();
			Query<UnidadVenta> query = session.createQuery("from UnidadVenta u order by u.nombreComercial asc", UnidadVenta.class);
			lista = query.getResultList();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return lista;
	}
	
	
	//Método para calcular la recaudación total directamente en la BD
	public float calcularRecaudacionTotal(String codigoUnico) {
	    float recaudacion = 0f;
	    try {
	        iniciaOperacion();
	        String hql = "select sum(i.cantidad * pl.precioVenta) " +
	                     "from Pedido p " +
	                     "join p.lstItems i " +
	                     "join i.plato pl " +
	                     "join p.unidadVenta uv " +
	                     "where uv.codigoUnico = :codigoUnico";
	                     
	        Double total = session.createQuery(hql, Double.class)
	                              .setParameter("codigoUnico", codigoUnico)
	                              .uniqueResult();
	                              
	        if (total != null) {
	            recaudacion = total.floatValue();
	        }
	    } finally {
	        if (session != null && session.isOpen()) session.close();
	    }
	    return recaudacion;
	}
}