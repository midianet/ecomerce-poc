package totvs.infra.broker.producer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import totvs.core.usecase.AlterarPrecoSku;

@Component
@RequiredArgsConstructor
public class PrecoSkuAlteradoProducer {

    @Value("${topico.preco.sku.alterado}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(@NonNull final AlterarPrecoSku.Out preco) {
        kafkaTemplate.send(topico, preco);
    }

}
