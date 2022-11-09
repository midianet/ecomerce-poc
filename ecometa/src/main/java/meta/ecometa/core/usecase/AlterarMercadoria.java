package meta.ecometa.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.infra.database.MercadoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarMercadoria {
    private final MercadoriaRepository repository;

    @Transactional
    public void execute(@NonNull final In mercadoria){
        repository.findById(mercadoria.id).ifPresentOrElse(persistent -> {
            BeanUtils.copyProperties(mercadoria , persistent,"id");
            repository.save(persistent);
        },() -> log.warn("Mercadoria não econtrada: {}",mercadoria.id));
    }

    public record In(
            String id,
            String descricao){}

}
