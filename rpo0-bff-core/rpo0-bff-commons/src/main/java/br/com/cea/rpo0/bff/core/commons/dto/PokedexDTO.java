package br.com.cea.rpo0.bff.core.commons.dto;

import java.util.List;

public class PokedexDTO {

    List<PokemonDTO> results;

    public List<PokemonDTO> getResults() {
        return results;
    }

    public void setResults(List<PokemonDTO> results) {
        this.results = results;
    }
}
