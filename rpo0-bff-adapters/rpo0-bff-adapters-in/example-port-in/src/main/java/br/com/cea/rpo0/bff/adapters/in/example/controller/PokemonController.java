package br.com.cea.rpo0.bff.adapters.in.example.controller;

import br.com.cea.rpo0.bff.core.application.example.PokemonCore;
import br.com.cea.rpo0.bff.core.commons.dto.PokedexDTO;
import br.com.cea.rpo0.bff.core.commons.dto.PokemonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonCore pokemonCore;

    @Operation(summary = "GetPokemon", description = "Consulta Pokemons")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso", content = @Content(schema = @Schema(implementation = PokemonDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @GetMapping
    public ResponseEntity<PokedexDTO> getPokemon(@RequestParam Integer limit) {
        try {
            PokedexDTO pokemonList = pokemonCore.getPokemon(limit);
            return ResponseEntity.ok(pokemonList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
