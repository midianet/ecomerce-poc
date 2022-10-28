package meta.ecometa.infra.broker;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.usecase.AlterarEstoqueProduto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EstoqueProdutoAlteradoConsumer {

    private final AlterarEstoqueProduto alterarEstoque;

    @KafkaListener(topics = "${topico.estoque.produto.alterado}", groupId = "${spring.kafka.consumer.group-id}", properties = {"spring.kafka.consumer.properties.spring.json.use.type.headers=false","spring.json.value.default.type=meta.ecometa.core.usecase.AlterarEstoqueProduto.In"})
    public void consume(@NonNull final AlterarEstoqueProduto.In estoque) {
        alterarEstoque.execute(estoque);
    }

}
