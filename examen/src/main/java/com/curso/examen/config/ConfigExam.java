package com.curso.examen.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigExam {
    
	@Bean
    public EntityManagerFactory getInstance() {
        return Persistence.createEntityManagerFactory("examen");
    }

}
