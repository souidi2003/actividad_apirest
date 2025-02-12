package iesthiar.modelo;

import java.sql.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

/**
 * Controlador REST para gestionar operaciones relacionadas con los coches.
 */
@Path
public class CocheController {

    /** Instancia de Gson configurada con un adaptador de fechas. */
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateAdapter())
            .create();

    /** Objeto DAO para manejar operaciones con la base de datos. */
    private CocheDao cocheDao;

    /**
     * Constructor que inicializa el DAO de coches.
     */
    public CocheController() {
        cocheDao = new JpaCocheDao();
    }

    /**
     * Obtiene la lista de todos los coches almacenados en la base de datos.
     *
     * @param response La respuesta HTTP donde se enviará la lista en formato JSON.
     * @param request  La solicitud HTTP recibida.
     */
    @GET("api/coches")
    public void getSaludo(Response response, Request request) {
        String json = gson.toJson(cocheDao.buscarTodos());
        response.text(json);
    }

    /**
     * Inserta un nuevo coche en la base de datos a partir de un JSON recibido.
     *
     * @param body     El cuerpo de la solicitud en formato JSON con los datos del coche.
     * @param response La respuesta HTTP.
     */
    @POST("/api/coches")
    public void insertCoche(@Body String body, Response response) {
        try {
            Coche coche = gson.fromJson(body, new TypeToken<Coche>() {}.getType());
            cocheDao.insert(coche);
            response.status(200);
        } catch (Exception e) {
            e.printStackTrace();
            response.status(400);
        }
    }

    /**
     * Actualiza la información de un coche existente en la base de datos.
     *
     * @param body     El cuerpo de la solicitud con los datos actualizados del coche en JSON.
     * @param response La respuesta HTTP.
     */
    @PUT("/api/coches")
    public void updateCoche(@Body String body, Response response) {
        try {
            Coche cocheActualizado = gson.fromJson(body, new TypeToken<Coche>() {}.getType());

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

    /**
     * Elimina un coche de la base de datos a partir de su matrícula.
     *
     * @param matricula Matrícula del coche a eliminar.
     * @param response  La respuesta HTTP.
     */
    @DELETE("/api/coches/:matricula")
    public void deleteCoche(@PathParam String matricula, Response response) {
        Coche cocheexis = cocheDao.buscarPorMatricula(matricula);
        if (cocheexis != null) {
            cocheDao.delete(cocheexis);
            response.status(200);
        } else {
            response.status(404);
        }
    }

    /**
     * Obtiene la información de un coche a partir de su ID.
     *
     * @param response La respuesta HTTP donde se enviará el JSON del coche.
     * @param request  La solicitud HTTP recibida.
     * @param codigo   El ID del coche a buscar.
     */
    @GET("/api/coche/:codigo")
    public void vistaCodigo(Response response, Request request, @PathParam int codigo) {
        Coche coche = cocheDao.buscarPorId(codigo);
        if (coche != null) {
            String json = gson.toJson(coche);
            response.text(json);
        } else {
            response.status(404);
        }
    }
}
