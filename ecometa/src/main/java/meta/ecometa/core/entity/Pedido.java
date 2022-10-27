package meta.ecometa.core.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {
    @Id
    private String id;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime data;

    private String cliente;
    private String vendedor;
    private Double valor;
    private Double frete;
    private Status status;
    private String rastreio;

    @Column(name = "cod_cep",nullable = true, length = 11)
    private String cep;


    @JoinColumn(name = "pedido_id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;

    public enum Status{
        NOVO, RECEBIDO, ENVIADO
    }

}