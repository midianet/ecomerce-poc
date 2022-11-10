package totvs.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import totvs.infra.database.SkuRepository;
import totvs.core.entity.Sku;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class ListarSku {

    private final SkuRepository repository;

    public Page<Sku> execute(@NonNull final Sku exemplo, @NonNull Pageable page) {
        if (Objects.nonNull(exemplo.getDescricao())) {
            final var matcher = ExampleMatcher.matchingAll()
                    .withMatcher("descricao", ExampleMatcher.GenericPropertyMatchers.startsWith());
            return repository.findAll(Example.of(exemplo,matcher), page);
        }else{
            return repository.findAll(page);
        }
    }

}
