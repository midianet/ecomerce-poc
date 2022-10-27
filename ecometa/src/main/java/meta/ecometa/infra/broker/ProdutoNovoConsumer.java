package meta.ecometa.infra.broker;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.entity.Produto;
import meta.ecometa.core.usecase.NovoProdutoUsecase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProdutoNovoConsumer {

    private final NovoProdutoUsecase novo;

    @KafkaListener(topics = "${topico.produto.novo}", groupId = "${spring.kafka.consumer.group-id}", properties = {"spring.kafka.consumer.properties.spring.json.use.type.headers=false","spring.json.value.default.type=meta.ecometa.core.entity.Produto"})
    public void consume(@NonNull final Produto produto) {
        novo.execute(produto);
    }

}