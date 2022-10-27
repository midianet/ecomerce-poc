package vtex.infra.broker.producer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import vtex.core.entity.Produto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoNovoProducer {

    @Value("${topico.produto.novo}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(@NonNull final Produto produto) {
        kafkaTemplate.send(topico, produto);
    }

}