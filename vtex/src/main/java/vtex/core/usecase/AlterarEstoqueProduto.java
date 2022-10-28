package vtex.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import vtex.infra.broker.producer.EstoqueProdutoAlteradoProducer;
import vtex.infra.broker.producer.ProdutoAlteradoProducer;
import vtex.infra.database.ProdutoRepository;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarEstoqueProduto {
    private final ProdutoRepository repository;
    private final ObterProdutoPorId obterPorId;
    private final EstoqueProdutoAlteradoProducer producer;

    @Transactional
    public void execute(@NonNull final String id, @NonNull final Double quantidade){
        final var persistent = obterPorId.execute(id);
        persistent.setEstoque(quantidade);
        repository.save(persistent);
        producer.send(new Out(id,quantidade));
    }

    public record Out(
            String produtoId,
            Double quantidade){}

}
