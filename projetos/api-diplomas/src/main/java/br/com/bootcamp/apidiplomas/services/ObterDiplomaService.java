package br.com.bootcamp.apidiplomas.services;

import br.com.bootcamp.apidiplomas.dto.AlunoDTO;
import br.com.bootcamp.apidiplomas.dto.DiplomaDTO;
import br.com.bootcamp.apidiplomas.entities.Aluno;
import br.com.bootcamp.apidiplomas.entities.Diploma;
import br.com.bootcamp.apidiplomas.entities.Disciplina;
import org.springframework.stereotype.Service;

@Service
public class ObterDiplomaService {

    public DiplomaDTO obterDiploma(AlunoDTO alunoDTO) {
        Aluno aluno = alunoDTO.toEntity();

        double mediaNotas = calcularMedia(aluno);

        String mensagem = withHonors(mediaNotas) ? "Parabéns, " + aluno.getNome() +
        " você foi aprovado com uma das melhores notas da turma!" : "Diploma de " +
        aluno.getNome() + ".";

        Diploma diplomaGerado = new Diploma(mensagem, mediaNotas, aluno);
        return diplomaGerado.toDto();
    }

    public double calcularMedia(Aluno aluno) {
        return aluno.getDisciplinas()
                .stream()
                .mapToDouble(Disciplina::getNota)
                .average()
                .orElse(0);
    }

    public boolean withHonors(double media) {
        return media > 9;
    }
}
