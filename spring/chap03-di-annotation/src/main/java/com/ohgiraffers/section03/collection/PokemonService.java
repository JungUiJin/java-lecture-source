package com.ohgiraffers.section03.collection;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PokemonService {

//    private List<Pokemon> pokemons;
//    @Autowired
//    public PokemonService(List<Pokemon> pokemons) {
//        this.pokemons = pokemons;
//    }
//
//    public void pokemonAttack(){
//        pokemons.forEach(Pokemon::attack);
//    }

    private Map<String, Pokemon> pokemons;
    public PokemonService(Map<String, Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    public void pokemonAttack(){
        pokemons.forEach((k,v)->{
            System.out.println(k + " " + v);
            v.attack();
        });
    }

}
