package meta.ecometa.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import meta.ecometa.core.entity.Produto;
import meta.ecometa.infra.database.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ObterProdutoPorIdUsecase {

    private final ProdutoRepository repository;

    public Produto execute(@NonNull final String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não econtrado"));
    }

}
