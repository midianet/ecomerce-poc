package meta.ecometa.infra.database;

import meta.ecometa.core.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,String> {

}
