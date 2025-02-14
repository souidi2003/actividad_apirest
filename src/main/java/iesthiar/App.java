package iesthiar;

import com.hellokaton.blade.Blade;
import com.hellokaton.blade.ioc.annotation.Bean;
import com.hellokaton.blade.loader.BladeLoader;
import com.hellokaton.blade.template.JetbrickTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 

{
    
    public static void main( String[] args )
    {
        /*
         * Crea una instancia de Blade y la configura para escuchar en el puerto 8081 y   
         * * arrancar el servidor.
         */
           Blade.create().listen(9069).start();
    }

    
}
