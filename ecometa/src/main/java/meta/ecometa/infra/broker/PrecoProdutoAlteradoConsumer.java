package meta.ecometa.infra.broker;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.usecase.AlterarPrecoProduto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PrecoProdutoAlteradoConsumer {

    private final AlterarPrecoProduto alterarPreco;

    @KafkaListener(topics = "${topico.preco.produto.alterado}", groupId = "${spring.kafka.consumer.group-id}", properties = {"spring.kafka.consumer.properties.spring.json.use.type.headers=false","spring.json.value.default.type=meta.ecometa.core.usecase.AlterarPrecoProduto.In"})
    public void consume(@NonNull final AlterarPrecoProduto.In preco) {
        alterarPreco.execute(preco);
    }

}
