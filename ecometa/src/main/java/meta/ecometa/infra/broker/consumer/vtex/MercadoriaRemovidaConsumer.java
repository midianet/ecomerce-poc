package meta.ecometa.infra.broker.consumer.vtex;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.usecase.RemoverMercadoria;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MercadoriaRemovidaConsumer {

    private final RemoverMercadoria remover;

    @KafkaListener(topics = "${topico.vtex.mercadoria.removida}",
                   groupId = "${spring.kafka.consumer.group-id}",
                   properties = {"spring.json.value.default.type=java.lang.String"})
    public void consume(@NonNull final String id) {
        remover.execute(id);
    }

}
