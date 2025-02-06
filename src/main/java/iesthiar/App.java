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
       Blade.create().listen(8081).start();
    }

    
}
