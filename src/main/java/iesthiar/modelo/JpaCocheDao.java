package iesthiar.modelo;

import java.util.List;

import iesthiar.curso.CocheDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Implementación de {@link CocheDao} utilizando JPA para gestionar coches en la base de datos.
 */
public class JpaCocheDao implements CocheDao {

    /** Factoría para gestionar la conexión con la base de datos. */
    private static EntityManagerFactory entityManagerFactory;

    /** Instancia única de JpaCocheDao para el patrón Singleton. */
    private static JpaCocheDao jpaCocheDao;

    /**
     * Constructor que inicializa la fábrica de entidades.
     */
    public JpaCocheDao() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    /**
     * Inserta un coche en la base de datos.
     *
     * @param c El coche a insertar.
     */
    @Override
    public void insert(Coche c) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(c);
        entityTransaction.commit();
        entityManager.close();
    }

    /**
     * Actualiza un coche en la base de datos.
     *
     * @param c El coche con los datos actualizados.
     */
    @Override
    public void update(Coche c) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(c);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Elimina un coche de la base de datos.
     *
     * @param c El coche a eliminar.
     */
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

    /**
     * Busca un coche por su matrícula.
     *
     * @param matricula Matrícula del coche a buscar.
     * @return El coche encontrado o {@code null} si no existe.
     */
    @Override
    public Coche buscarPorMatricula(String matricula) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Coche coche = entityManager.createQuery("SELECT c FROM Coche c WHERE c.matricula = :matricula", Coche.class)
        .setParameter("matricula", matricula)
        .getSingleResult();

        entityManager.close();
        return coche;
    }
    
    /**
     * Método no implementado para buscar coches por propietario.
     *
     * @param id ID del propietario.
     * @return Excepción indicando que el método no está implementado.
     */
    @Override
    public List<Coche> buscarrPorPropietario(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarrPorPropietario'");
    }

    /**
     * Obtiene todos los coches almacenados en la base de datos.
     *
     * @return Lista de coches.
     */
    @Override
    public List<Coche> buscarTodos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Coche> coches = entityManager.createQuery("from Coche", Coche.class).getResultList();
        entityManager.close();
        return coches;
    }

    /**
     * Obtiene la instancia única de {@code JpaCocheDao}.
     *
     * @return Instancia de {@code JpaCocheDao}.
     */
    public static JpaCocheDao instancia() {
        if (jpaCocheDao == null) {
            jpaCocheDao = new JpaCocheDao();
        }
        return jpaCocheDao;
    }

    /**
     * Busca un coche por su ID.
     *
     * @param id ID del coche a buscar.
     * @return El coche encontrado o {@code null} si no existe.
     */
    @Override
    public Coche buscarPorId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Coche coche = entityManager.find(Coche.class, id);
        return coche;
    }
}
