package br.com.bootcamp.apidiplomas.dto;

import br.com.bootcamp.apidiplomas.entities.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DisciplinaDTO {

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 50)
    @Pattern(regexp = "[a-zA-Z\\s]+", message = "Digite apenas letras")
    private String nome;

    @NotNull
    @DecimalMin("1")
    @DecimalMax("10")
    private double nota;

    public Disciplina toEntity() {
        return new Disciplina()
                .setNome(this.nome)
                .setNota(this.nota);
    }
}
