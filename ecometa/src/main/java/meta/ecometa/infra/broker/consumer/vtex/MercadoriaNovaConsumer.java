package meta.ecometa.infra.broker.consumer.vtex;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.entity.Mercadoria;
import meta.ecometa.core.usecase.NovaMercadoria;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MercadoriaNovaConsumer {

    private final NovaMercadoria novo;

    @KafkaListener(topics = "${topico.vtex.mercadoria.nova}",
                   groupId = "${spring.kafka.consumer.group-id}",
                   properties = {"spring.json.value.default.type=meta.ecometa.core.entity.Mercadoria"})
    public void consume(final Mercadoria mercadoria) {
        novo.execute(mercadoria);
    }

}
