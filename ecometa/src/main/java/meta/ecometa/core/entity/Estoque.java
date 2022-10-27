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
public class Estoque {
    @Id
    private String id;

    @Column(nullable = false,length = 20, unique = true)
    private String sku;

    @Column(nullable = false, length = 20)
    private String descricao;

}