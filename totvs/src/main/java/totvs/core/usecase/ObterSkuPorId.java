package totvs.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import totvs.core.entity.Sku;
import totvs.infra.database.SkuRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ObterSkuPorId {

    private final SkuRepository repository;

    public Sku execute(@NonNull final String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sku não econtrado"));
    }

}
