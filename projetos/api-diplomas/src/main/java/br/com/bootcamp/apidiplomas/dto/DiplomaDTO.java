package br.com.bootcamp.apidiplomas.dto;

import br.com.bootcamp.apidiplomas.entities.Aluno;
import lombok.Data;

@Data
public class DiplomaDTO {

    private String mensagem;
    private Double media;
    private AlunoDTO aluno;

    public DiplomaDTO(String mensagem, Double media, AlunoDTO aluno) {
        this.mensagem = mensagem;
        this.media = media;
        this.aluno = aluno;
    }
}
