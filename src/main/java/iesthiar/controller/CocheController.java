package iesthiar.controller;




import com.hellokaton.blade.annotation.Path;
import com.hellokaton.blade.annotation.route.GET;
import com.hellokaton.blade.mvc.http.Request;
import com.hellokaton.blade.mvc.http.Response;


import iesthiar.service.CocheServiceImpl;

@Path
public class CocheController {
    CocheServiceImpl cocheService = new CocheServiceImpl();
    @GET("api/coches")
    public void getSaludo(Response response, Request request){ {
        request.attribute("coches", cocheService.getAllClientes());
        response.json("rrasdf");     
    }
    
}}
