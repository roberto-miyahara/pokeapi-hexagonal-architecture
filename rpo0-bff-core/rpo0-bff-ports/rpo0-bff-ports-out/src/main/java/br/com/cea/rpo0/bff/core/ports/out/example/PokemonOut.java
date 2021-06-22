package br.com.cea.rpo0.bff.core.ports.out.example;

import br.com.cea.rpo0.bff.core.commons.dto.PokedexDTO;

public interface PokemonOut {

    PokedexDTO getPokemon(Integer limit);

}
