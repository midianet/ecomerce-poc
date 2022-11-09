package meta.ecometa.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import meta.ecometa.core.entity.Mercadoria;
import meta.ecometa.infra.database.MercadoriaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ObterMercadoriaPorId {

    private final MercadoriaRepository repository;

    public Mercadoria execute(@NonNull final String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mercadoria não econtrada"));
    }

}
