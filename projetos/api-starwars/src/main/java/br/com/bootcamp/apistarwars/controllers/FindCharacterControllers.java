package br.com.bootcamp.apistarwars.controllers;

import br.com.bootcamp.apistarwars.entities.Character;
import br.com.bootcamp.apistarwars.services.FindCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/characters")
public class FindCharacterControllers {

    private final FindCharacterService findCharacterService;

    @Autowired
    public FindCharacterControllers(FindCharacterService findCharacterService) {
        this.findCharacterService = findCharacterService;
    }

    @GetMapping
    public ResponseEntity<List<Character>> lisCharacter(@RequestParam(defaultValue = "") String name) {
        return new ResponseEntity<>(findCharacterService.listCharacter(name), HttpStatus.OK);
    }
}
