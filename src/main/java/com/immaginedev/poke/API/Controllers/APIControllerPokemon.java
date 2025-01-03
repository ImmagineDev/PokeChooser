package com.immaginedev.poke.API.Controllers;


import com.immaginedev.poke.API.Exceptions.EmptyName;
import com.immaginedev.poke.API.Exceptions.PokemonNotFound;
import com.immaginedev.poke.API.Exceptions.WrongFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pokemon")
public class APIControllerPokemon {

    @Value("${pokemon.uri.pokemon}")
    private String uri;


    @GetMapping
    public ResponseEntity<?> getPokemon(@RequestParam("name")String name){
        if(name == null || name.isEmpty()){
            throw new EmptyName("Pokemon name is missing");
        }


        if(!name.matches("^[a-zA-Z]+$")){
            throw new WrongFormat("Wrong format");
        }

        String name_formated = name.toLowerCase();
        final String url = uri + name_formated;

        try{
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(url, String.class);

            System.out.println(result);

            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (HttpClientErrorException.NotFound e){
            throw new PokemonNotFound("Pokemon not found");
        }
    }


}
