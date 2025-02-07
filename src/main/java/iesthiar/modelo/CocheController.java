package iesthiar.modelo;





import com.hellokaton.blade.annotation.Path;
import com.hellokaton.blade.annotation.route.GET;
import com.hellokaton.blade.mvc.http.Request;
import com.hellokaton.blade.mvc.http.Response;




@Path
public class CocheController {

   CocheDao controladorCoche = new JpaCocheDao();
    @GET("api/coches")
    public void getSaludo(Response response, Request request){ {
        request.attribute("coches", controladorCoche.buscarTodos());
        response.json("rrasdf");     
    }
    
}}
