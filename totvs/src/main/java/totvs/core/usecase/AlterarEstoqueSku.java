package totvs.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import totvs.infra.broker.producer.EstoqueSkuAlteradoProducer;
import totvs.infra.database.SkuRepository;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarEstoqueSku {
    private final SkuRepository repository;
    private final ObterSkuPorId obterPorId;
    private final EstoqueSkuAlteradoProducer producer;

    @Transactional
    public void execute(@NonNull final String id, @NonNull final Double quantidade){
        final var persistent = obterPorId.execute(id);
        persistent.setEstoque(quantidade);
        repository.save(persistent);
        producer.send(new Out(id,quantidade));
    }

    public record Out(
            String id,
            Double quantidade){}

}
