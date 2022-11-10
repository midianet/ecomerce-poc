package totvs.infra.broker.producer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SkuRemovidoProducer {

    @Value("${topico.sku.removido}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(@NonNull final String id) {
        kafkaTemplate.send(topico, id);
    }

}