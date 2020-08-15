package com.example.springhateoas;

import com.example.springhateoas.model.Owner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.EntityLinks;

@SpringBootApplication
public class SpringHateoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHateoasApplication.class, args);


    }




}
