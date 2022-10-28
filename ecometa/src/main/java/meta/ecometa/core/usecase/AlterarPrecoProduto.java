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
public class AlterarPrecoProduto {
    private final ProdutoRepository repository;
    private final ObterProdutoPorId obterPorId;

    @Transactional
    public void execute(@NonNull final In preco){
        final var persistent = obterPorId.execute(preco.produtoId);
        persistent.setPreco(preco.valor);
        repository.save(persistent);
    }

    public record In(
            String produtoId,
            Double valor){}

}
