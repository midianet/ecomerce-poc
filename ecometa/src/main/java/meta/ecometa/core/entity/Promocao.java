package meta.ecometa.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promocao {
    @Id
    private String id;

    private String nome;

    private Boolean todos;

    @OneToMany
    private List<Produto> incluidos;

    @OneToMany
    private List<Produto> excetos;

    private Double desconto;

    private LocalDateTime inicio;
    private LocalDateTime fim;
}