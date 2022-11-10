package totvs.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import totvs.infra.broker.producer.SkuAlteradoProducer;
import totvs.infra.database.SkuRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarSku {
    private final SkuRepository repository;
    private final ObterSkuPorId obterPorId;
    private final SkuAlteradoProducer producer;

    @Transactional
    public void execute(@NonNull final String id, @NonNull final AlterarSku.In sku){
        final var persistent = obterPorId.execute(id);
        BeanUtils.copyProperties(sku , persistent,"id");
        repository.save(persistent);
        producer.send(persistent);
    }

    public record In(
        @NotBlank
        @Size(min = 3, max = 80)
        String descricao){}

}
