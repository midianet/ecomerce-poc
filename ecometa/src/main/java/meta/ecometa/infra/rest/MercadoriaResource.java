package meta.ecometa.infra.rest;

import lombok.RequiredArgsConstructor;
import meta.ecometa.core.entity.Mercadoria;
import meta.ecometa.core.usecase.ListarMercadoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mercadorias")
public class MercadoriaResource {
    private final ListarMercadoria listar;

    @GetMapping
    public Page<Mercadoria> find(@RequestParam(required = false) final String descricao,
                                 @PageableDefault final Pageable pageable) {
        final var example = Mercadoria.builder();
        Optional.ofNullable(descricao).ifPresent(example::descricao);
        return listar.execute(example.build(),pageable);
    }

}
