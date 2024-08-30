package com.ohgiraffers.section05.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.ohgiraffers");
        PokemonService pokemonService = applicationContext.getBean("pokemonServiceInject", PokemonService.class);
        pokemonService.pokemonAttack();
    }
}
