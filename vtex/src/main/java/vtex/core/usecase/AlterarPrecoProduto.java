package vtex.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import vtex.infra.broker.producer.PrecoProdutoAlteradoProducer;
import vtex.infra.database.ProdutoRepository;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarPrecoProduto {
    private final ProdutoRepository repository;
    private final ObterProdutoPorId obterPorId;
    private final PrecoProdutoAlteradoProducer producer;

    @Transactional
    public void execute(@NonNull final String id, @NonNull final Double valor){
        final var persistent = obterPorId.execute(id);
        persistent.setPreco(valor);
        repository.save(persistent);
        producer.send(new Out(id,valor));
    }

    public record Out(
            String produtoId,
            Double valor){}

}
