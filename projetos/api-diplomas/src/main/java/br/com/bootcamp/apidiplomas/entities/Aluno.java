package br.com.bootcamp.apidiplomas.entities;

import java.util.List;

public class Aluno {

    private String nome;
    private List<Disciplinas> disciplinas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplinas> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplinas> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
