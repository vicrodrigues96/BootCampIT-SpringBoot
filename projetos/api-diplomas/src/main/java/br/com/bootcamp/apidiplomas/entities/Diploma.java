package br.com.bootcamp.apidiplomas.entities;

import br.com.bootcamp.apidiplomas.dto.DiplomaDTO;
import lombok.Data;

@Data
public class Diploma {

    private String mensagem;
    private Double media;
    private Aluno aluno;

    public Diploma(String mensagem, Double media, Aluno aluno) {
        this.mensagem = mensagem;
        this.media = media;
        this.aluno = aluno;
    }
    public DiplomaDTO toDto() {
        return new DiplomaDTO(this.mensagem, this.media, this.aluno.toDto());
    }
}
