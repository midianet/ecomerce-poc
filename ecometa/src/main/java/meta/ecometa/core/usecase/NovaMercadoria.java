package meta.ecometa.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.entity.Mercadoria;
import meta.ecometa.infra.database.MercadoriaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class NovaMercadoria {
    private final MercadoriaRepository repository;

    @Transactional
    public void execute(@NonNull final Mercadoria mercadoria){
        repository.save(mercadoria);
        log.debug("Nova Mercadoria criada {}", mercadoria.getId());
    }

}
