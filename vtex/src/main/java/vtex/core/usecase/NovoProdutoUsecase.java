package vtex.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vtex.core.entity.Produto;
import vtex.infra.broker.producer.ProdutoNovoProducer;
import vtex.infra.database.ProdutoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NovoProdutoUsecase {
    private final ProdutoRepository repository;
    private final ProdutoNovoProducer producer;

    @Transactional
    public void execute(@NonNull final Produto produto){
        produto.setId(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())));
        produto.setEstoque(Optional.ofNullable(produto.getEstoque()).orElse(0.0));
        produto.setValor(Optional.ofNullable(produto.getValor()).orElse(0.0));
        repository.save(produto);
        producer.send(produto);
    }

}