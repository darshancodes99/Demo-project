package com.codes.darshan.demoProject.configration;

import com.codes.darshan.demoProject.DB;
import com.codes.darshan.demoProject.DevDB;
import com.codes.darshan.demoProject.ProDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean(){
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProDBBean(){
        return new ProDB();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
