package com.pokemon.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.pokemon.api.service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{name}/id")
    public ResponseEntity<JsonNode> getId(@PathVariable String name) throws JsonProcessingException {
        JsonNode pokemonId = pokemonService.getId(name);
        return new ResponseEntity<>(pokemonId, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<JsonNode> getName(@PathVariable String name) throws JsonProcessingException {
        JsonNode pokemonName = pokemonService.getName(name);
        return new ResponseEntity<>(pokemonName, HttpStatus.OK);
    }

    @GetMapping("/{name}/abilities")
    public ResponseEntity<JsonNode> getAbilities(@PathVariable String name) throws JsonProcessingException {
        JsonNode abilities = pokemonService.getAbilities(name);
        return new ResponseEntity<>(abilities, HttpStatus.OK);
    }

    @GetMapping("/{name}/baseExperience")
    public ResponseEntity<JsonNode> getBaseExperience(@PathVariable String name) throws JsonProcessingException {
        JsonNode baseExperience = pokemonService.getBaseExperience(name);
        return new ResponseEntity<>(baseExperience, HttpStatus.OK);
    }

    @GetMapping("/{name}/heldItems")
    public ResponseEntity<JsonNode> getHeldItems(@PathVariable String name) throws JsonProcessingException {
        JsonNode heldItems = pokemonService.getHeldItems(name);
        return new ResponseEntity<>(heldItems, HttpStatus.OK);
    }

    @GetMapping("/{name}/locations")
    public ResponseEntity<JsonNode> getLocations(@PathVariable String name) throws JsonProcessingException {
        JsonNode locations = pokemonService.getLocations(name);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> defaultLocation() {
        return new ResponseEntity<>("Missing Location", HttpStatus.OK);
    }

}
