package DAOImplements;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProveedor;
import model.TblProveedorcl2;
import model.TblUsuariocl2;

public class DAOProveedor implements IProveedor {

	@Override
	public void RegistrarProveedor(TblProveedorcl2 pro) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAExamen");
		EntityManager em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(pro);
			System.out.println("REGISTRADO CORRECTAMENTE");
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			e.getMessage();
			System.out.println("NO SE PUEDE REGISTRAR EN LA TABLA");
			// TODO: handle exception
		}finally {
			em.close();
			emf.close();
		}
		
		
	}

	@Override
	public void ActualizarProveedor(TblProveedorcl2 pro) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAExamen");
		EntityManager em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(pro);
			System.out.println("ACTUALIZADO CORRECTAMENTE");
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			e.getMessage();
			System.out.println("NO SE PUEDE ACTUALIZAR EN LA TABLA");
			// TODO: handle exception
		}finally {
			em.close();
			emf.close();
		}
		
	}

	@Override
	public void EliminarProveedor(TblProveedorcl2 pro) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAExamen");
		EntityManager em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			TblUsuariocl2 elimcli=em.find(TblUsuariocl2.class, pro.getIdprooveedorcl2());
			
			if(elimcli!=null) {
				em.remove(elimcli);
				System.out.println("ELIMINADO CORRECTAMENTE");
				em.getTransaction().commit();
			}else {
				System.out.println("Usuario no encontrado en la base de datos");
			}
		} catch (RuntimeException e) {
			e.getMessage();
			System.out.println("NO SE PUEDE ELIMINAR EN LA TABLA");
			// TODO: handle exception
		}finally {
			em.close();
			emf.close();
		}
		
	}

	@Override
	public List<TblProveedorcl2> ListarProveedor() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAExamen");
		EntityManager em=emf.createEntityManager();
		List<TblProveedorcl2> listado=null;
		try {
			em.getTransaction().begin();
			listado=em.createQuery("select p from TblProveedor p",TblProveedorcl2.class).getResultList();
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			e.getMessage();
			System.out.println("NO SE PUEDE LISTAR EN LA TABLA");
			// TODO: handle exception
		}finally {
			em.close();
			emf.close();
		}
		return listado;
	}

	@Override
	public TblProveedorcl2 BuscarProveedor(TblProveedorcl2 pro) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAExamen");
		EntityManager em=emf.createEntityManager();
		TblProveedorcl2 listado=null;
		try {
			em.getTransaction().begin();
			listado=em.find(TblProveedorcl2.class, pro.getIdprooveedorcl2());
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			e.getMessage();
			System.out.println("NO SE PUEDE BUSCAR EN LA TABLA");
			// TODO: handle exception
		}finally {
			em.close();
			emf.close();
		}
		return listado;
	}

}
