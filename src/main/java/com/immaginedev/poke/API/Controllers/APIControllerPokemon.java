package com.immaginedev.poke.API.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.immaginedev.poke.API.DTOs.Pokemon.Form;
import com.immaginedev.poke.API.DTOs.Pokemon.Pokemon;
import com.immaginedev.poke.API.Exceptions.EmptyName;
import com.immaginedev.poke.API.Exceptions.PokemonNotFound;
import com.immaginedev.poke.API.Exceptions.WrongFormat;
import com.immaginedev.poke.Utils.Randomizer;

@RestController
@RequestMapping("/pokemon")
public class APIControllerPokemon {

    @Value("${pokemon.uri.pokemon}")
    private String uri;


    @GetMapping
    public ResponseEntity<?> getPokemon(@RequestParam("name") String name) {
        if(name == null || name.isEmpty()) {
            throw new EmptyName("Pokemon name is missing");
        }

        if(!name.matches("^[a-zA-Z]+$")) {
            throw new WrongFormat("Wrong format");
        }

        String name_formated = name.toLowerCase();
        final String url = uri + name_formated;

        try {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);

            System.out.println(result);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (HttpClientErrorException.NotFound e) {
            throw new PokemonNotFound("Pokemon not found");
        }
    }

    @GetMapping("/random")
    public ResponseEntity<?> getRandomStarters(@RequestParam("size") int size) {
        int id = 0;

        try {
            RestTemplate restTemplate = new RestTemplate();
            String result = "";

            for(int i = 0; i < size; i++) {
                id = Randomizer.getRandomNumber(1, 0151);
                String url = uri + id;
                
                Pokemon pokemon = restTemplate.getForObject(url, Pokemon.class);
                List<Form> forms = pokemon.getForms();

                if(forms == null)
                    throw new PokemonNotFound("The Pokemon with id " + id + " was not found");
                    
                if(i != 0)
                    result += "\r\n";
                
                result += forms.get(0).getName();
            }

            System.out.println(result);

            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (HttpClientErrorException.NotFound e) {
            throw new PokemonNotFound("The Pokemon with id " + id + " was not found");
        }
    }
    
}