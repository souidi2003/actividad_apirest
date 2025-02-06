package iesthiar.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iesthiar.modelo.Coche;
import iesthiar.repository.CocheRepository;

@Service
public class CocheServiceImpl implements CocheService  {
    @Autowired
    private CocheRepository cocheService;

    @Override
    public Coche save(Coche empleado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Coche> getAllClientes() {
      return cocheService.findAll();
    }

    @Override
    public Coche findClienteById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findClienteById'");
    }

    @Override
    public Coche findClienteByDni(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findClienteByDni'");
    }

    @Override
    public Coche updateCliente(Coche cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCliente'");
    }

    @Override
    public void deleteCliente(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCliente'");
    }

    @Override
    public List<Coche> findByMarca(String marca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByMarca'");
    }
    
}
