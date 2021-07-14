package br.com.bootcamp.apidiplomas.dto;

import br.com.bootcamp.apidiplomas.entities.Aluno;
import br.com.bootcamp.apidiplomas.entities.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Valid
public class AlunoDTO {

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 50)
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "Digite apenas letras")
    private String nome;
    @Valid
    @NotNull
    private List<DisciplinaDTO> disciplinas;

    public Aluno toEntity() {
        List<Disciplina> listaDisciplinas = this.disciplinas
                .stream()
                .map(d -> d.toEntity())
                .collect(Collectors.toList());

        return new Aluno()
                .setNome(this.nome)
                .setDisciplinas(listaDisciplinas);
    }
}
