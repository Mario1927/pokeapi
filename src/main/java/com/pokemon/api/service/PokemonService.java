package com.pokemon.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    public ObjectMapper mapper = new ObjectMapper();

    @Autowired
    RestTemplate restTemplate;

    public final String url = "https://pokeapi.co/api/v2/pokemon/";

    public JsonNode getId(String name) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url + name, String.class);
        return mapper.readTree(response.getBody()).path("id");
    }

    public JsonNode getName(String name) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url + name, String.class);
        return mapper.readTree(response.getBody()).path("name");
    }

    public JsonNode getAbilities(String name) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url + name, String.class);
        return mapper.readTree(response.getBody()).path("abilities");
    }

    public JsonNode getBaseExperience(String name) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url + name, String.class);
        return mapper.readTree(response.getBody()).path("base_experience");
    }

    public JsonNode getHeldItems(String name) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url + name, String.class);
        return mapper.readTree(response.getBody()).path("held_items");
    }

    public JsonNode getLocations(String name) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(url + name, String.class);
        String locationsUrl = mapper.readTree(response.getBody()).path("location_area_encounters").asText();
        response = restTemplate.getForEntity(locationsUrl, String.class);
        return mapper.readTree(response.getBody());
    }
}
