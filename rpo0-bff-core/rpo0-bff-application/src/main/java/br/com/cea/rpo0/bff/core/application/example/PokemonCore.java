package br.com.cea.rpo0.bff.core.application.example;

import br.com.cea.rpo0.bff.core.commons.dto.PokedexDTO;
import br.com.cea.rpo0.bff.core.ports.out.example.PokemonOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonCore {

    @Autowired
    private PokemonOut pokemonOut;

    public PokedexDTO getPokemon(Integer limit){
        PokedexDTO pokemonList = pokemonOut.getPokemon(limit);
        return pokemonList;
    }
}
