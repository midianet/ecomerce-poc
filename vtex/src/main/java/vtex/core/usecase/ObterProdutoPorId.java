package vtex.core.usecase;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vtex.core.entity.Produto;
import vtex.infra.database.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ObterProdutoPorId {

    private final ProdutoRepository repository;

    public Produto execute(@NonNull final String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não econtrado"));
    }

}
