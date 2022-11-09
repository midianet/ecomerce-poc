package meta.ecometa.infra.database;

import meta.ecometa.core.entity.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercadoriaRepository extends JpaRepository<Mercadoria,String> {

}