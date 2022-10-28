package vtex.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vtex.core.entity.Produto;
import vtex.infra.broker.producer.ProdutoNovoProducer;
import vtex.infra.database.ProdutoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NovoProduto {
    private final ProdutoRepository repository;
    private final ProdutoNovoProducer producer;

    @Transactional
    public Produto execute(@NonNull final In produto){
        final var novo = Produto.builder()
                .id(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())))
                .descricao(produto.descricao)
                .estoque(Optional.ofNullable(produto.estoque).orElse(0.0))
                .preco(Optional.ofNullable(produto.preco).orElse(0.0))
                .build();
        repository.save(novo);
        producer.send(novo);
        return novo;
    }

    public record In(
        @NotBlank
        @Size(min = 3, max = 80)
        String descricao,

        @NotNull
        @PositiveOrZero
        Double preco,

        @NotNull
        @PositiveOrZero
        Double estoque ){}

}
