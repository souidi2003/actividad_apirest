package iesthiar.curso;




import java.util.List;

import iesthiar.modelo.Coche;



public interface CocheDao {
 public void insert(Coche c);
    public void update(Coche c);
    public void delete(Coche c);
    public Coche buscarPorMatricula(String matricula);
    public List<Coche> buscarrPorPropietario(int id);
    public List<Coche> buscarTodos();
    public Coche buscarPorId(int id);
   
    
} 
    

