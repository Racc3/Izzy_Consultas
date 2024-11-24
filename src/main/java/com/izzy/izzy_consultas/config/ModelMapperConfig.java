package com.izzy.izzy_consultas.config;

import ch.qos.logback.core.model.Model;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper ModelMapper(){
        return new ModelMapper();
    }

}
