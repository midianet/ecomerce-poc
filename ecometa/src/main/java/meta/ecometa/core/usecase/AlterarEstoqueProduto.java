package meta.ecometa.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.infra.database.ProdutoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarEstoqueProduto {
    private final ProdutoRepository repository;
    private final ObterProdutoPorId obterPorId;

    @Transactional
    public void execute(@NonNull final In estoque){
        final var persistent = obterPorId.execute(estoque.produtoId);
        persistent.setEstoque(estoque.quantidade);
        repository.save(persistent);
    }

    public record In(
            String produtoId,
            Double quantidade){}

}
