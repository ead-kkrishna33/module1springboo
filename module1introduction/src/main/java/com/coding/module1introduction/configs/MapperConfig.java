package com.coding.module1introduction.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getModalMapper(){
        return  new ModelMapper();
    }
}
