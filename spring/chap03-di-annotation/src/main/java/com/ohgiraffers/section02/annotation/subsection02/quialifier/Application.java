package com.ohgiraffers.section02.annotation.subsection02.quialifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");
        PokemonService pokemonService = applicationContext.getBean("pokemonServiceQualifier", PokemonService.class);
        pokemonService.pokemonAttack();
    }
}
