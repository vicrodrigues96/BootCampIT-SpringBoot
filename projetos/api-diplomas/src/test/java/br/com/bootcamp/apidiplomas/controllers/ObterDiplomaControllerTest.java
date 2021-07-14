package br.com.bootcamp.apidiplomas.controllers;

import br.com.bootcamp.apidiplomas.dto.AlunoDTO;
import br.com.bootcamp.apidiplomas.dto.DiplomaDTO;
import br.com.bootcamp.apidiplomas.dto.DisciplinaDTO;
import br.com.bootcamp.apidiplomas.entities.Aluno;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ObterDiplomaControllerTest {

    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void deveGerarUmDiploma() throws Exception {

        String payload = mapper.writeValueAsString(retornaJsonDiploma());

        mock.perform(post("/aluno")
                .contentType("application/json")
                .content(payload))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.media", is(9.5)));
    }

    public AlunoDTO retornaJsonDiploma() {
        List<DisciplinaDTO> disciplinas = Arrays.asList(
                new DisciplinaDTO("Matematica", 10),
                new DisciplinaDTO("Historia", 9)
        );

        return new AlunoDTO("Victor Rodrigues", disciplinas);
    }
}
