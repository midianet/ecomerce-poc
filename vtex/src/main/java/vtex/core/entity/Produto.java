package vtex.core.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {
    @Id
    private String id;

    @NotBlank
    @Size(min = 3, max = 80)
    @Column(nullable = false, length = 80)
    private String descricao;

    @NotNull
    @PositiveOrZero
    private Double preco;

    @NotNull
    @PositiveOrZero
    private Double estoque;

}
