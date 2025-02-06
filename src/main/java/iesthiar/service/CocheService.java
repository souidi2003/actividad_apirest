package iesthiar.service;


import java.util.List;

import iesthiar.modelo.Coche;

public interface CocheService {
    Coche save(Coche empleado);

    List<Coche> getAllClientes();

    Coche findClienteById(long id);

    Coche findClienteByDni(String dni);

    Coche updateCliente(Coche cliente);

    void deleteCliente(long id);

    List<Coche> findByMarca(String marca);
}
