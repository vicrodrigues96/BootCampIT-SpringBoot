package br.com.bootcamp.apidiplomas.services;

import br.com.bootcamp.apidiplomas.dto.DiplomaDTO;
import br.com.bootcamp.apidiplomas.entities.Aluno;
import br.com.bootcamp.apidiplomas.entities.Diploma;
import br.com.bootcamp.apidiplomas.entities.Disciplinas;
import org.springframework.stereotype.Service;

@Service
public class ObterDiplomaService {

    public DiplomaDTO obterDiploma(Aluno aluno) {
        double totalNotas = aluno.getDisciplinas().stream().mapToDouble(Disciplinas::getNota).sum();
        double mediaNotas = totalNotas / aluno.getDisciplinas().size();

        String mensagem = mediaNotas > 9 ? "Parabéns, "+ aluno.getNome() +
                " você foi aprovado com uma das melhores notas da turma!" : "Diploma de "+
                aluno.getNome() +".";

        Diploma diplomaGerado = new Diploma(mensagem, mediaNotas, aluno);
        return diplomaGerado.toDto();
    }
}
