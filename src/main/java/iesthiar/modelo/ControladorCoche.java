package iesthiar.modelo;


import java.util.List;

import iesthiar.curso.CocheDao;

public class ControladorCoche {
    CocheDao cocheDao= new JpaCocheDao();
    void registrarCoche(Coche c){
        cocheDao.insert(c);
    }
    void updateCoche(Coche c){
        cocheDao.update(c);
    }
    void deleteCoche(Coche c){
        cocheDao.delete(c);
    }
    Coche buscarporMatricula(String matricula){
        return cocheDao.buscarPorMatricula(matricula);
    }
    List<Coche> buscarporPropietario(int id){
        return cocheDao.buscarrPorPropietario(id);
    }
    public static void main(String[] args) {
        ControladorCoche cc= new ControladorCoche();
        // cc.registrarCoche(new Coche("5422c", "seat", "leon", new Date(), new Cliente("52458", "jj", "loko", 632457157,1)));
        // // cc.deleteCoche(new Coche("5422c", "mercedes", "amg", new Date(), new Cliente("52458", "aa", "fff", 6312345)));
        
        // System.out.println(cc.buscarporMatricula("5422c"));
       cc.buscarporPropietario(1).forEach(coche->System.out.println(coche.toString()));
       
    }
}
