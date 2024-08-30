package com.ohgiraffers.section02.annotation.subsection02.quialifier;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    // @Qualifier : 여러 개의 빈 객체 중 특정 빈 객체를 이름으로 지정하는 어노테이션 Primary < Qualifier

    // 1. 필드 주입
//    @Autowired
//    @Qualifier("pikachu")
    private Pokemon pokemon;

    // 생성자 주입
    @Autowired
    public PokemonService(@Qualifier("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack(){
        pokemon.attack();
    }
}
