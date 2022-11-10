package meta.ecometa.infra.broker.consumer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.usecase.AlterarMercadoria;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MercadoriaAlteradaConsumer {

    private final AlterarMercadoria alterar;

    @KafkaListener(topics = "${topico.mercadoria.alterada}",
                   groupId = "${spring.kafka.consumer.group-id}",
                   properties = {"spring.json.value.default.type=meta.ecometa.core.usecase.AlterarMercadoria.In"})
    public void consume(@NonNull final AlterarMercadoria.In mercadoria) {
        alterar.execute(mercadoria);
    }

}
