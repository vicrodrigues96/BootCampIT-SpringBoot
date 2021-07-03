package br.com.bootcamp.apistarwars.repositories;

import br.com.bootcamp.apistarwars.entities.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterRepository {

    private final File FILE = new File("src/main/resources/static/starwars.json");

    private ObjectMapper mapper;

    @Autowired
    public CharacterRepository(ObjectMapper mapper) {
        this.mapper = mapper;
        System.out.println("passou");
        charactersList();
    }

    public List<Character> charactersList() {
        List<Character> characters = new ArrayList<>();

        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Character>> typeReference = new TypeReference<List<Character>>() {
            };

            characters = mapper.readValue(is, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }
}
