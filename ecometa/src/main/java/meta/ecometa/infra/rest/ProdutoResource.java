package meta.ecometa.infra.rest;

import lombok.RequiredArgsConstructor;
import meta.ecometa.core.entity.Produto;
import meta.ecometa.core.usecase.ListarProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/produtos")
public class ProdutoResource {
    private final ListarProduto listar;

    @GetMapping
    public Page<Produto> find(@RequestParam(required = false) final String descricao,
                              @PageableDefault final Pageable pageable) {
        final var example = Produto.builder();
        Optional.ofNullable(descricao).ifPresent(example::descricao);
        return listar.execute(example.build(),pageable);
    }

}
