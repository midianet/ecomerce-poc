package meta.ecometa.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import meta.ecometa.core.entity.Mercadoria;
import meta.ecometa.infra.database.MercadoriaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListarMercadoria {

    private final MercadoriaRepository repository;

    public Page<Mercadoria> execute(@NonNull final Mercadoria exemplo, @NonNull Pageable page) {
        final var matcher = ExampleMatcher.matchingAll()
                .withMatcher("descricao", ExampleMatcher.GenericPropertyMatchers.startsWith());
        return repository.findAll(Example.of(exemplo,matcher), page);
    }

}
