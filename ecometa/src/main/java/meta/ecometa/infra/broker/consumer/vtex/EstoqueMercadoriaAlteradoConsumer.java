package meta.ecometa.infra.broker.consumer.vtex;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.usecase.AlterarEstoqueMercadoria;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EstoqueMercadoriaAlteradoConsumer {

    private final AlterarEstoqueMercadoria alterarEstoque;

    @KafkaListener(topics = "${topico.vtex.estoque.mercadoria.alterado}",
                   groupId = "${spring.kafka.consumer.group-id}",
                   properties = {"spring.json.value.default.type=meta.ecometa.core.usecase.AlterarEstoqueMercadoria.In"})
    public void consume(@NonNull final AlterarEstoqueMercadoria.In estoque) {
        alterarEstoque.execute(estoque);
    }

}
