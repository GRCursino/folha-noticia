package model;

import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ResultadoDAO {

       private static ResultadoDAO instance;
       protected EntityManager entityManager;
        
       public static ResultadoDAO getInstance(){
         if (instance == null){
            instance = new ResultadoDAO();
         }
          
         return instance;
       }
 
       private ResultadoDAO() {
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
 
       public Resultado getById(final int id) {
         return entityManager.find(Resultado.class, id);
       }
 
       @SuppressWarnings("unchecked")
       public List<Resultado> findAll() {
         return entityManager.createQuery("FROM " + 
         Resultado.class.getName()).getResultList();
       }
 
       public void persist(Resultado resultado) {
         try {
            entityManager.getTransaction().begin();
            entityManager.persist(resultado);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }
 
       public void merge(Resultado resultado) {
         try {
            entityManager.getTransaction().begin();
            entityManager.merge(resultado);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }
 
       public void remove(Resultado resultado) {
         try {
            entityManager.getTransaction().begin();
            resultado = entityManager.find(Resultado.class, resultado.getId());
            entityManager.remove(resultado);
            entityManager.getTransaction().commit();
         } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
         }
       }
 
       public void removeById(final int id) {
         try {
            Resultado resultado = getById(id);
            remove(resultado);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
       }
 
}
