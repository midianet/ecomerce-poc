package totvs.infra.database;

import totvs.core.entity.Sku;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuRepository extends JpaRepository<Sku,String> {

}