package br.com.cea.rpo0.bff.adapters.out.example;

import br.com.cea.rpo0.bff.core.commons.dto.PokedexDTO;
import br.com.cea.rpo0.bff.core.ports.out.example.PokemonOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PokemonOutImpl implements PokemonOut {

    @Autowired
    RestTemplate restTemplate;

    String API_URL = "pokeapi.co/api/v2/pokemon";


    @Override
    public PokedexDTO getPokemon(Integer limit) {
        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(API_URL)
                //.path("pokemon")
                .queryParam("limit", limit)
                .build();
        PokedexDTO obj =  restTemplate.getForObject(uri.toUriString(), PokedexDTO.class);
        System.out.println(obj);
        return obj;
    }
}
