package br.com.cea.rpo0.bff.adapters.out.example;

import br.com.cea.rpo0.bff.core.commons.dto.PokedexDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PokemonOutImplTest {

    private Integer limit = 10;
    private String API_URL = "pokeapi.co/api/v2/pokemon";
    String owner = "octocat";
    String repo = "hello-world";
    Integer artifactId = 42;

    @Test
    public void consumerAPI() {
        //https://pokeapi.co/api/v2/pokemon?limit=10
        //https://api.github.com/repos/octocat/hello-world/actions/artifacts/42
        RestTemplate restTemplate = new RestTemplate();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(API_URL)
                .queryParam("limit", limit)
                //.path(owner + "/" + repo + "/actions/artifacts/" + artifactId)
                .build();

        //ResponseEntity<PokemonDTO> entity = restTemplate.exchange(uri.toUriString(), HttpMethod.GET, http, PokemonDTO.class);
        PokedexDTO obj = restTemplate.getForObject(uri.toUriString(), PokedexDTO.class);
        System.out.println(obj);
    }
}
