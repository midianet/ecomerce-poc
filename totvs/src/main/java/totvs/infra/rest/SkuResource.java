package totvs.infra.rest;

import lombok.RequiredArgsConstructor;
import totvs.core.entity.Sku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import totvs.core.usecase.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/skus")
public class SkuResource {
    private final ListarSku listar;
    private final ObterSkuPorId obterPorId;
    private final AlterarSku alterar;
    private final NovoSku novo;
    private final RemoverSku remover;
    private final AlterarEstoqueSku alterarEstoque;
    private final AlterarPrecoSku alterarPreco;

    @GetMapping("/{id}")
    public Sku get(@PathVariable final String id){
        return obterPorId.execute(id);
    }

    @GetMapping
    public Page<Sku> find(@RequestParam(required = false) final String descricao,
                              @PageableDefault final Pageable pageable) {
        final var example = Sku.builder();
        Optional.ofNullable(descricao).ifPresent(example::descricao);
        return listar.execute(example.build(),pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@Valid @RequestBody final NovoSku.In sku,
                     final HttpServletResponse response) {
        final var persistent = novo.execute(sku);
        response.setHeader(HttpHeaders.LOCATION,
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(persistent.getId())
                        .toUri().toString()
        );
    }

    @PatchMapping("/{id}/preco")
    public void patchPreco(@PathVariable final String id, @RequestParam Double valor){
        alterarPreco.execute(id,valor);
    }

    @PatchMapping("/{id}/estoque")
    public void patchEstoque(@PathVariable final String id, @RequestParam Double quantidade){
        alterarEstoque.execute(id,quantidade);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable final String id,
                    @Valid @RequestBody final AlterarSku.In sku) {
        alterar.execute(id, sku);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final String id) {
        remover.execute(id);
    }

}