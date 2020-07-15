package model;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

public class UsuarioDAO {

    private static UsuarioDAO instance;
    protected EntityManager entityManager;
     
    public static UsuarioDAO getInstance(){
      if (instance == null){
         instance = new UsuarioDAO();
      }
       
      return instance;
    }

    private UsuarioDAO() {
      entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
     EntityManagerFactory factory = 
     Persistence.createEntityManagerFactory("calculadora");
     if (entityManager == null) {
       entityManager = factory.createEntityManager();
     }

     return entityManager;
    }

    public Usuario getById(final int id) {
      return entityManager.find(Usuario.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Resultado> findAll() {
      return entityManager.createQuery("FROM " + 
      Usuario.class.getName()).getResultList();
    }

    public void persist(Usuario usuario) {
      try {
         entityManager.getTransaction().begin();
         entityManager.persist(usuario);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void merge(Usuario usuario) {
      try {
         entityManager.getTransaction().begin();
         entityManager.merge(usuario);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void remove(Usuario usuario) {
      try {
         entityManager.getTransaction().begin();
         usuario = entityManager.find(Usuario.class, usuario.getId_user());
         entityManager.remove(usuario);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
    }

    public void removeById(final int id) {
      try {
         Usuario usuario = getById(id);
         remove(usuario);
      } catch (Exception ex) {
         ex.printStackTrace();
      }
    }

    public Usuario findByEmail(final String email) {
      Usuario usuario = null;
      
      Query query = entityManager.createQuery("FROM " + Usuario.class.getName()+ " U WHERE U.email = :email").setParameter("email", email);
      
      usuario = (Usuario) query.getResultList().get(0);
      
      return usuario;
  }

    public boolean validate(final String email, final String senha) {
      Usuario usuario = null;
  
      Query query = entityManager.createQuery("FROM " + Usuario.class.getName() + " U WHERE U.email = :email").setParameter("email", email);
      
      usuario = (Usuario) query.getResultList().get(0);
      
      if (usuario != null && usuario.getSenha().equals(senha)) {
          return true;
      }
      
      return false;
  }

}