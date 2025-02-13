package iesthiar;

import com.hellokaton.blade.Blade;
import com.hellokaton.blade.ioc.annotation.Bean;
import com.hellokaton.blade.loader.BladeLoader;
import com.hellokaton.blade.template.JetbrickTemplateEngine;

@Bean
public class TempoleteConfig implements BladeLoader {

    @Override
    public void load(Blade blade) {
        // Configura el motor de plantillas Jetbrick.
        blade.templateEngine(new JetbrickTemplateEngine());
    }
    
}
