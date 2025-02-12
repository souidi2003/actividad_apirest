package iesthiar.modelo;

import java.util.List;

import iesthiar.curso.CocheDao;

/**
 * Controlador de la entidad Coche. Proporciona métodos para gestionar coches en la base de datos.
 */
public class ControladorCoche {

    /** Objeto DAO para manejar operaciones con la base de datos de coches. */
    CocheDao cocheDao = new JpaCocheDao();

    /**
     * Registra un nuevo coche en la base de datos.
     *
     * @param c El coche a registrar.
     */
    void registrarCoche(Coche c) {
        cocheDao.insert(c);
    }

    /**
     * Actualiza la información de un coche existente en la base de datos.
     *
     * @param c El coche con los datos actualizados.
     */
    void updateCoche(Coche c) {
        cocheDao.update(c);
    }

    /**
     * Elimina un coche de la base de datos.
     *
     * @param c El coche a eliminar.
     */
    void deleteCoche(Coche c) {
        cocheDao.delete(c);
    }

    /**
     * Busca un coche en la base de datos por su matrícula.
     *
     * @param matricula La matrícula del coche a buscar.
     * @return El coche encontrado o {@code null} si no existe.
     */
    Coche buscarporMatricula(String matricula) {
        return cocheDao.buscarPorMatricula(matricula);
    }

    /**
     * Busca coches asociados a un propietario en la base de datos.
     *
     * @param id El ID del propietario.
     * @return Una lista de coches pertenecientes al propietario.
     */
    List<Coche> buscarporPropietario(int id) {
        return cocheDao.buscarrPorPropietario(id);
    }

    /**
     * Método principal para probar las funcionalidades del controlador.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        ControladorCoche cc = new ControladorCoche();

        // Descomentar para probar funcionalidades
        // cc.registrarCoche(new Coche("5422c", "Seat", "Leon", new Date(), new Cliente("52458", "jj", "loko", 632457157, 1)));
        // cc.deleteCoche(new Coche("5422c", "Mercedes", "AMG", new Date(), new Cliente("52458", "aa", "fff", 6312345)));

        // Buscar coche por matrícula
        // System.out.println(cc.buscarporMatricula("5422c"));

        // Buscar coches por propietario y mostrarlos en consola
        cc.buscarporPropietario(1).forEach(coche -> System.out.println(coche.toString()));
    }
}
