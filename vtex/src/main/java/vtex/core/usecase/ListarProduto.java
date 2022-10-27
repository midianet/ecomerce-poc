package vtex.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vtex.infra.database.ProdutoRepository;
import vtex.core.entity.Produto;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class ListarProduto {

    private final ProdutoRepository repository;

    public Page<Produto> execute(@NonNull final Produto exemplo, @NonNull Pageable page) {
        if (Objects.nonNull(exemplo.getDescricao())) {
            final var matcher = ExampleMatcher.matchingAll()
                    .withMatcher("descricao", ExampleMatcher.GenericPropertyMatchers.startsWith());
            return repository.findAll(Example.of(exemplo,matcher), page);
        }else{
            return repository.findAll(page);
        }
    }

}
