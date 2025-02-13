package iesthiar.modelo;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
    private final SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private final SimpleDateFormat formato2 = new SimpleDateFormat("MMM d, yyyy", Locale.ENGLISH); 

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

    @Override
    public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(formato1.format(date)); // Siempre devuelve yyyy-MM-dd
    }
}
