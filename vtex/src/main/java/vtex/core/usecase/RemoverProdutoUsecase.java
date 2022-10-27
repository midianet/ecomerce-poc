package vtex.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vtex.infra.broker.producer.ProdutoRemovidoProducer;
import vtex.infra.database.ProdutoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemoverProdutoUsecase {
    private final ProdutoRepository repository;
    private final ObterProdutoPorIdUsecase obterPorId;

    private final ProdutoRemovidoProducer producer;

    @Transactional
    public void execute(@NonNull final String id){
        final var persistent = obterPorId.execute(id);
        repository.delete(persistent);
        producer.send(id);
    }

}