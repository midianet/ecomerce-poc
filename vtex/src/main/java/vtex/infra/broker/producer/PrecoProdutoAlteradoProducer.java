package vtex.infra.broker.producer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import vtex.core.usecase.AlterarPrecoProduto;

@Component
@RequiredArgsConstructor
public class PrecoProdutoAlteradoProducer {

    @Value("${topico.preco.produto.alterado}")
    private String topico;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(@NonNull final AlterarPrecoProduto.Out preco) {
        kafkaTemplate.send(topico, preco);
    }

}
