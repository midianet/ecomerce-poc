package meta.ecometa.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.infra.database.MercadoriaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoverMercadoria {
    private final MercadoriaRepository repository;

    @Transactional
    public void execute(@NonNull final String id){
        repository.findById(id).ifPresentOrElse(persistent -> {
            repository.deleteById(id);
        },() -> log.warn("Mercadoria não econtrada: {}",id));
    }

}
