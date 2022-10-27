package vtex.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vtex.core.entity.Produto;
import vtex.infra.broker.producer.ProdutoAlteradoProducer;
import vtex.infra.database.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarProdutoUsecase {
    private final ProdutoRepository repository;
    private final ObterProdutoPorIdUsecase obterPorId;
    private final ProdutoAlteradoProducer producer;

    @Transactional
    public void execute(@NonNull final String id, @NonNull final Produto produto){
        final var persistent = obterPorId.execute(id);
        BeanUtils.copyProperties(produto , persistent,"id");
        repository.save(persistent);
        producer.send(persistent);
    }

}