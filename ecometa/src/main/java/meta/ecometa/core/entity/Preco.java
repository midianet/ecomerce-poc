package meta.ecometa.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Preco {
    @Id
    private String id;

    @ManyToOne
    private Produto produto;

    private Double valor;

    private LocalDateTime inicio;

    private LocalDateTime fim;

}