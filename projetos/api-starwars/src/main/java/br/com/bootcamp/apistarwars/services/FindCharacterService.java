package br.com.bootcamp.apistarwars.services;

import br.com.bootcamp.apistarwars.entities.Character;
import br.com.bootcamp.apistarwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class FindCharacterService {

    private CharacterRepository characterRepository;

    @Autowired
    public FindCharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> listAllCharacters() {
        return characterRepository.charactersList();
    }

    public List<Character> listCharacter(String name) {
        List<Character> resultado = new ArrayList<>();
        List<Character> charactersFound = listAllCharacters().stream().filter(c -> c.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        resultado.addAll(charactersFound);

        return resultado;
    }
}
