package iesthiar.modelo;
import java.util.List;

import iesthiar.curso.CocheDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;











public class JpaCocheDao implements CocheDao{
    private static  EntityManagerFactory entityManagerFactory ;
    private static JpaCocheDao jpaCocheDao;
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
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Coche c) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
    
        Coche cochePersistente = entityManager.find(Coche.class, c.getId());
        if (cochePersistente != null) {
            entityManager.remove(cochePersistente);  
        } else {
            System.out.println("El coche no se encuentra en la base de datos");
        }
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public Coche buscarPorMatricula(String matricula) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Coche coche = entityManager.createQuery("SELECT c FROM Coche c WHERE c.matricula = :matricula", Coche.class)
        .setParameter("matricula", matricula)
        .getSingleResult();

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
    public static JpaCocheDao instancia(){
        if(jpaCocheDao==null){
            jpaCocheDao=new JpaCocheDao();
            return jpaCocheDao;
        }
        return jpaCocheDao;
    }

    @Override
    public Coche buscarPorId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Coche coche = entityManager.find(Coche.class, id);
        return coche;
    }
    
}
