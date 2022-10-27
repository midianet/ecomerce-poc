package meta.ecometa.infra.broker;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.usecase.RemoverProdutoUsecase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProdutoRemovidoConsumer {

    private final RemoverProdutoUsecase remover;

    @KafkaListener(topics = "${topico.produto.removido}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@NonNull final String id) {
        remover.execute(id);
    }

}