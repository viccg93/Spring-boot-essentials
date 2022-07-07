package com.udemy.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//la clase configuradora debe de estar anotada con Configuration y definir los sources con PropertySources
@Configuration
@PropertySources({
        @PropertySource("classpath:msgs.properties")
})
public class MsgsPropertiesConf {
}
