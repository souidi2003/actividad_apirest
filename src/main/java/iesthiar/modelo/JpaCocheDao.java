package iesthiar.modelo;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;


import iesthiar.modelo.Coche;


public class JpaCocheDao implements CocheDao{
    private static EntityManagerFactory entityManagerFactory ;
    public JpaCocheDao(){
        this.entityManagerFactory= Persistence.createEntityManagerFactory("default");
    }

    @Override
    public void insert(Coche c) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.persist(c);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public void update(Coche c) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(c);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(Coche c) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(c);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public Coche buscarPorMatricula(String matricula) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Coche coche = entityManager.find(Coche.class, matricula);
        entityManager.close();
        return coche;
    }
    
    @Override
    public List<Coche> buscarrPorPropietario(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarrPorPropietario'");
    }

    @Override
    public List<Coche> buscarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Coche> coches = entityManager.createQuery("from Coche", Coche.class).getResultList();
        entityManager.close();
        return coches;
    }
    
}
