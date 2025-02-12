package iesthiar.modelo;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Adaptador de fecha para Gson.
 * Permite la serialización y deserialización de objetos {@link Date} en formato JSON.
 */
public class DateAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {

    /** Formato principal de fecha (yyyy-MM-dd). */
    private final SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    /** Formato alternativo de fecha (MMM d, yyyy), e.g., "May 24, 2003". */
    private final SimpleDateFormat formato2 = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH); 

    /**
     * Deserializa una fecha desde un JSON.
     *
     * @param json     El elemento JSON con la fecha.
     * @param typeOfT  Tipo del objeto esperado.
     * @param context  Contexto de deserialización.
     * @return Un objeto {@link Date} con la fecha convertida.
     * @throws JsonParseException Si el formato de fecha no es válido.
     */
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String fechaStr = json.getAsString();
        try {
            return formato1.parse(fechaStr); // Intenta con yyyy-MM-dd
        } catch (ParseException e) {
            try {
                return formato2.parse(fechaStr); // Si falla, intenta con "May 24, 2003"
            } catch (ParseException ex) {
                throw new JsonParseException("Formato de fecha no válido: " + fechaStr);
            }
        }
    }

    /**
     * Serializa un objeto {@link Date} a JSON en formato yyyy-MM-dd.
     *
     * @param date      Objeto Date a serializar.
     * @param typeOfSrc Tipo del objeto fuente.
     * @param context   Contexto de serialización.
     * @return Un {@link JsonElement} con la fecha en formato de cadena.
     */
    @Override
    public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(formato1.format(date)); // Siempre devuelve yyyy-MM-dd
    }
}
