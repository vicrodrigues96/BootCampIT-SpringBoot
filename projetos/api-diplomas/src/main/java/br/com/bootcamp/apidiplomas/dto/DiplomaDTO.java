package br.com.bootcamp.apidiplomas.dto;

import br.com.bootcamp.apidiplomas.entities.Aluno;

public class DiplomaDTO {

    private String mensagem;
    private Double media;
    private Aluno aluno;

    public DiplomaDTO(String mensagem, Double media, Aluno aluno) {
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
}
