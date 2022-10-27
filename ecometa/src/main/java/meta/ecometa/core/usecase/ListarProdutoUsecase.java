package meta.ecometa.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import meta.ecometa.core.entity.Produto;
import meta.ecometa.infra.database.ProdutoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListarProdutoUsecase {

    private final ProdutoRepository repository;

    public Page<Produto> execute(@NonNull final Produto exemplo, @NonNull Pageable page) {
        final var matcher = ExampleMatcher.matchingAll()
                .withMatcher("descricao", ExampleMatcher.GenericPropertyMatchers.startsWith());
        return repository.findAll(Example.of(exemplo,matcher), page);
    }

}
