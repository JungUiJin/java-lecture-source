package com.ohgiraffers.section05.inject;

import com.ohgiraffers.section02.common.Pokemon;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceInject")
public class PokemonService {


    /*
    Inject : 자바 진영에서 제공하는 DI 어노테이션
    AutoWired 스프링 어노테이션과 유사하게 type 을 통해 의존성 주입을 하여 @Named를 통해 빈 이름을 명시할 수 있다. */

//    @Inject
//    @Named("pikachu")
    private Pokemon pokemon;

    @Inject
    public PokemonService(@Named("pikachu") Pokemon pokemon){
        this.pokemon = pokemon;
    }


    public void pokemonAttack(){
        pokemon.attack();
    }
}
