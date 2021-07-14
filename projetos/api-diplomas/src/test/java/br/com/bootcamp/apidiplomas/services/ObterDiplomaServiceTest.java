package br.com.bootcamp.apidiplomas.services;

import br.com.bootcamp.apidiplomas.dto.AlunoDTO;
import br.com.bootcamp.apidiplomas.dto.DiplomaDTO;
import br.com.bootcamp.apidiplomas.dto.DisciplinaDTO;
import br.com.bootcamp.apidiplomas.entities.Aluno;
import br.com.bootcamp.apidiplomas.entities.Disciplina;
import br.com.bootcamp.apidiplomas.exception.SemNotasCadastradasException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.gen5.api.Assertions.*;

public class ObterDiplomaServiceTest {

    @Test
    void deveObterUmDiploma() {
        //Arrange -> Entrada
        ObterDiplomaService obterDiplomaService = new ObterDiplomaService();
        List<DisciplinaDTO> listaDisciplinas = new ArrayList<>();
        listaDisciplinas.add(new DisciplinaDTO("Matematica", 10));
        listaDisciplinas.add(new DisciplinaDTO("Portugues", 9));
        AlunoDTO alunoDTO = new AlunoDTO("Victor", listaDisciplinas);

        //Act -> Ação
        DiplomaDTO diplomaGerado = obterDiplomaService.obterDiploma(alunoDTO);

        //Assert -> Resultado

        assertEquals(9.5, diplomaGerado.getMedia());
        assertEquals("Victor", diplomaGerado.getAluno().getNome());
        assertNotEquals(null, diplomaGerado.getAluno());
        assertTrue(diplomaGerado.getMensagem().contains("Parabéns"));
    }

    @Test
    void deveCalcularMedia() {
        //Arrange
        ObterDiplomaService obterDiplomaService = new ObterDiplomaService();
        List<Disciplina> disciplinas = Arrays.asList(
                new Disciplina("Portugues", 9),
                new Disciplina("Matematica", 10));

        Aluno aluno = new Aluno("Victor", disciplinas);

        //Act
        double mediaCalculada = obterDiplomaService.calcularMedia(aluno);

        //Assert
        assertTrue(mediaCalculada > 9);
        assertEquals(9.5, mediaCalculada);
        assertNotEquals(9, mediaCalculada);
    }

    @Test
    public void deveRetornarComHonra() {
        ObterDiplomaService obterDiplomaService = new ObterDiplomaService();

        boolean comHonras = obterDiplomaService.withHonors(9.5);

        assertTrue(comHonras);
        assertNotEquals(false, comHonras);
    }

    @Test
    public void deveRetornarUmaExcecao() {
        ObterDiplomaService obterDiplomaService = new ObterDiplomaService();

        Aluno aluno = new Aluno("Nome Teste", new ArrayList<>());

        assertThrows(SemNotasCadastradasException.class, () -> obterDiplomaService.obterDiploma(aluno.toDto()));
    }
}
