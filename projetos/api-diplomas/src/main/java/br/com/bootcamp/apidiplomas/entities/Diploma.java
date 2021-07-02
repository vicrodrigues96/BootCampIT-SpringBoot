package br.com.bootcamp.apidiplomas.entities;

import br.com.bootcamp.apidiplomas.dto.DiplomaDTO;

public class Diploma {

    private String mensagem;
    private Double media;
    private Aluno aluno;

    public Diploma(String mensagem, Double media, Aluno aluno) {
        this.mensagem = mensagem;
        this.media = media;
        this.aluno = aluno;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public DiplomaDTO toDto() {
        return new DiplomaDTO(this.mensagem, this.media, this.aluno);
    }
}
