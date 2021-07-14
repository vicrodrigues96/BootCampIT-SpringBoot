package br.com.bootcamp.apidiplomas.entities;

import br.com.bootcamp.apidiplomas.dto.DisciplinaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Disciplina {

    private String nome;
    private double nota;

    public DisciplinaDTO toDto() {
        return new DisciplinaDTO()
                .setNome(this.nome)
                .setNota(this.nota);
    }
}
