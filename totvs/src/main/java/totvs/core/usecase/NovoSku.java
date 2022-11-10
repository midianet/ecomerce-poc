package totvs.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import totvs.core.entity.Sku;
import totvs.infra.broker.producer.SkuNovoProducer;
import totvs.infra.database.SkuRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NovoSku {
    private final SkuRepository repository;
    private final SkuNovoProducer producer;

    @Transactional
    public Sku execute(@NonNull final In sku){
        final var novo = Sku.builder()
                .id(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())))
                .descricao(sku.descricao)
                .estoque(Optional.ofNullable(sku.estoque).orElse(0.0))
                .preco(Optional.ofNullable(sku.preco).orElse(0.0))
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
