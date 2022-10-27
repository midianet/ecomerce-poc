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

    @NotEmpty
    @Size(min = 3, max = 80)
    @Column(nullable = false, length = 20)
    private String descricao;

    @NotNull
    @PositiveOrZero
    private Double valor;

    @NotNull
    @PositiveOrZero
    private Double estoque;

}