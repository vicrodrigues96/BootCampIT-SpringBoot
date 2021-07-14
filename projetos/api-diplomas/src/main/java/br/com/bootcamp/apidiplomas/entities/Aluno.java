package br.com.bootcamp.apidiplomas.entities;

import br.com.bootcamp.apidiplomas.dto.AlunoDTO;
import br.com.bootcamp.apidiplomas.dto.DisciplinaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Aluno {

    @NotNull
    @NotEmpty
    @NotBlank
    private String nome;
    @Valid
    private List<Disciplina> disciplinas;

    public AlunoDTO toDto() {
        List<DisciplinaDTO> listaDisciplinasDtos = this.disciplinas
                .stream()
                .map(d -> d.toDto())
                .collect(Collectors.toList());

        return new AlunoDTO()
                .setNome(this.nome)
                .setDisciplinas(listaDisciplinasDtos);

    }
}
