package iesthiar.modelo;





import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hellokaton.blade.annotation.Path;
import com.hellokaton.blade.annotation.request.Body;
import com.hellokaton.blade.annotation.route.GET;
import com.hellokaton.blade.annotation.route.POST;
import com.hellokaton.blade.mvc.http.Request;
import com.hellokaton.blade.mvc.http.Response;

import iesthiar.curso.CocheDao;



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
    @POST("/api/coche")
    public void insertCoche(@Body String body,Response response){
        try {
            Coche curso = new Gson().fromJson(body, new TypeToken<Coche>() {}.getType());
           response.status(200);
        } catch (Exception e) {
            e.printStackTrace();
            response.status(400);
        }
    }    

}


