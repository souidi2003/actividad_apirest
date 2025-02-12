package iesthiar.modelo;





import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hellokaton.blade.annotation.Path;
import com.hellokaton.blade.annotation.request.Body;
import com.hellokaton.blade.annotation.request.PathParam;
import com.hellokaton.blade.annotation.route.DELETE;
import com.hellokaton.blade.annotation.route.GET;
import com.hellokaton.blade.annotation.route.POST;
import com.hellokaton.blade.annotation.route.PUT;
import com.hellokaton.blade.mvc.http.Request;
import com.hellokaton.blade.mvc.http.Response;

import iesthiar.curso.CocheDao;
import iesthiar.curso.Curso;



@Path
public class CocheController {
private CocheDao cocheDao;
    public CocheController(){
        cocheDao = new JpaCocheDao();
   }
   
    @GET("api/coches")
    public void getSaludo(Response response, Request request){ 

        response.json(cocheDao.buscarTodos());     
    }
     /**
     * Añadimso un curso por api
     * @param body
     * @param response
     */
    @POST("/api/coches")
    public void insertCoche(@Body String body,Response response){
        try {
            Coche coche = new Gson().fromJson(body, new TypeToken<Coche>() {}.getType());
            cocheDao.insert(coche);
           response.status(200);
        } catch (Exception e) {
            e.printStackTrace();
            response.status(400);
        }
    }  
    @PUT("/api/coches")
    public void updateCoche(@Body String body, Response response) {
    try {
        
        Coche cocheActualizado = new Gson().fromJson(body, new TypeToken<Coche>() {}.getType());

        
        Coche cocheExistente = cocheDao.buscarPorMatricula(cocheActualizado.getMatricula());

        if (cocheExistente != null) {
            
            cocheExistente.setMarca(cocheActualizado.getMarca());
            cocheExistente.setModelo(cocheActualizado.getModelo());
            cocheExistente.setFecha(cocheActualizado.getFecha());

            
            cocheDao.update(cocheExistente);

            
            response.status(200);
        } else {
            
            response.status(404);
            response.text("Coche no encontrado");
        }

    } catch (Exception e) {
        e.printStackTrace();
        response.status(400);
        response.text("Error al procesar la solicitud");
    }
}
@DELETE("/api/coches/:matricula")
public void deleteCoche(@PathParam String  matricula, Response response){
  Coche cocheexis= cocheDao.buscarPorMatricula(matricula);
  if (cocheexis!=null){
    cocheDao.delete(cocheexis);
    response.status(200);

}else{
    response.status(404);
}
}

  @GET("/api/coche/:codigo")
    public void vistaCodigo(Response response, Request request,@PathParam int codigo){
       Coche coche=cocheDao.buscarPorId(codigo);
        if (coche!=null){
            response.json(coche);
        }
        else
        response.status(404);
    }



}


