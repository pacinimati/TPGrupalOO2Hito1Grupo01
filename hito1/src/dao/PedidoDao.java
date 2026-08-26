package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.Pedido;

public class PedidoDao {
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

	public long agregar(Pedido objeto) {
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

	public void actualizar(Pedido objeto) {
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

	public void eliminar(Pedido objeto) {
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

	public Pedido traer(long idPedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = session.get(Pedido.class, idPedido);
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return objeto;
	}

	public Pedido traerConItems(long idPedido) {
		Pedido p = null;
		try {
			iniciaOperacion();
			// Hacemos JOIN FETCH tanto a la lista de ítems como al plato asociado a cada ítem
			p = session.createQuery(
					"select p from Pedido p left join fetch p.lstItems i left join fetch i.plato where p.id = :idPedido", 
					Pedido.class)
					.setParameter("idPedido", idPedido)
					.uniqueResult();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return p;
	}

	public List<Pedido> traer() {
		List<Pedido> lista = new ArrayList<>();
		try {
			iniciaOperacion();
			Query<Pedido> query = session.createQuery("from Pedido p order by p.fechaTransaccion desc", Pedido.class);
			lista = query.getResultList();
		} finally {
			if (session != null && session.isOpen()) session.close();
		}
		return lista;
	}
}