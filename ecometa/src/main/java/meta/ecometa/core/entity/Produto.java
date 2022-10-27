package meta.ecometa.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto{
    @Id
    private String id;

    @Column(nullable = false, length = 20)
    private String descricao;

    private Double valor;

    private Double estoque;

}