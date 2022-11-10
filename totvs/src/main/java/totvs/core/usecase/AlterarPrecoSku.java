package totvs.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import totvs.infra.broker.producer.PrecoSkuAlteradoProducer;
import totvs.infra.database.SkuRepository;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarPrecoSku {
    private final SkuRepository repository;
    private final ObterSkuPorId obterPorId;
    private final PrecoSkuAlteradoProducer producer;

    @Transactional
    public void execute(@NonNull final String id, @NonNull final Double valor){
        final var persistent = obterPorId.execute(id);
        persistent.setPreco(valor);
        repository.save(persistent);
        producer.send(new Out(id,valor));
    }

    public record Out(
            String id,
            Double valor){}

}
