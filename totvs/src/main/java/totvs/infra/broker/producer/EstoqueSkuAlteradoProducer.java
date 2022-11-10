package totvs.infra.broker.producer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import totvs.core.usecase.AlterarEstoqueSku;

@Component
@RequiredArgsConstructor
public class EstoqueSkuAlteradoProducer {

    @Value("${topico.estoque.sku.alterado}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(@NonNull final AlterarEstoqueSku.Out estoque) {
        kafkaTemplate.send(topico, estoque);
    }

}
