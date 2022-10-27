package meta.ecometa.infra.database;

import meta.ecometa.core.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,String> {

}