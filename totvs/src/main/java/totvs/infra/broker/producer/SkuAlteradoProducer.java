package totvs.infra.broker.producer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import totvs.core.entity.Sku;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SkuAlteradoProducer {

    @Value("${topico.sku.alterado}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(@NonNull final Sku sku) {
        kafkaTemplate.send(topico, sku);
    }

}