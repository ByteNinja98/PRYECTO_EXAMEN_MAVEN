package DAOImplements;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuario;
import model.TblUsuariocl2;

public class DAOUsuario implements IUsuario {

	@Override
	public void RegistrarUsuario(TblUsuariocl2 usu) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAExamen");
		EntityManager em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(usu);
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
	public void ActualizarUsuario(TblUsuariocl2 usu) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAExamen");
		EntityManager em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(usu);
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
	public void EliminarUsuario(TblUsuariocl2 usu) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAVeterinaria");
		EntityManager em=emf.createEntityManager();
		try {
			em.getTransaction().begin();
			TblUsuariocl2 elimcli=em.find(TblUsuariocl2.class, usu.getIdusuariocl2());
			
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
	public List<TblUsuariocl2> ListarUsuario() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAVeterinaria");
		EntityManager em=emf.createEntityManager();
		List<TblUsuariocl2> listado=null;
		try {
			em.getTransaction().begin();
			listado=em.createQuery("select u from TblUsuario u",TblUsuariocl2.class).getResultList();
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
	public TblUsuariocl2 BuscarUsuario(TblUsuariocl2 usu) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProyectoJPAVeterinaria");
		EntityManager em=emf.createEntityManager();
		TblUsuariocl2 listado=null;
		try {
			em.getTransaction().begin();
			listado=em.find(TblUsuariocl2.class, usu.getIdusuariocl2());
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
