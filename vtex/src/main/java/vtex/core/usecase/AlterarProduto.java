package vtex.core.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vtex.infra.broker.producer.ProdutoAlteradoProducer;
import vtex.infra.database.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlterarProduto {
    private final ProdutoRepository repository;
    private final ObterProdutoPorId obterPorId;
    private final ProdutoAlteradoProducer producer;

    @Transactional
    public void execute(@NonNull final String id, @NonNull final AlterarProduto.In produto){
        final var persistent = obterPorId.execute(id);
        BeanUtils.copyProperties(produto , persistent,"id");
        repository.save(persistent);
        producer.send(persistent);
    }

    public record In(
        @NotBlank
        @Size(min = 3, max = 80)
        String descricao){}

}
