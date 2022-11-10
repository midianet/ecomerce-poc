package totvs.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import totvs.infra.broker.producer.SkuRemovidoProducer;
import totvs.infra.database.SkuRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoverSku {
    private final SkuRepository repository;
    private final ObterSkuPorId obterPorId;

    private final SkuRemovidoProducer producer;

    @Transactional
    public void execute(@NonNull final String id){
        final var persistent = obterPorId.execute(id);
        repository.delete(persistent);
        producer.send(id);
    }

}