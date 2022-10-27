package meta.ecometa.core.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class Pagamento implements Serializable {
    private String pedido;
}