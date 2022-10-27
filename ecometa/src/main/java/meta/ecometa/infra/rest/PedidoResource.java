package meta.ecometa.infra.rest;

import lombok.RequiredArgsConstructor;
import meta.ecometa.core.entity.Pedido;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.List;

//@RestController
//@RequiredArgsConstructor
//@RequestMapping(value = "/pedidos")
public class PedidoResource {
//
//    private final CriarPedidoUsecase criarPedido;
//    private final ListarPedidosUsecase listarPedidos;
//
//    private final LimparTudoUsecase limparTudo;
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    @Transactional
//    public void create(@RequestBody CriarPedidoUsecase.CriarPedidoIn create, HttpServletResponse response) {
//        response.setHeader(HttpHeaders.LOCATION, ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(criarPedido.execute(create).id())
//                .toUri()
//                .toString());
//    }
//
//    @GetMapping
//    public List<Pedido> list(){
//        return listarPedidos.execute();
//    }
//
//    @PostMapping("/limpar")
//    public void limpar(){
//        limparTudo.execute();
//    }
//

}