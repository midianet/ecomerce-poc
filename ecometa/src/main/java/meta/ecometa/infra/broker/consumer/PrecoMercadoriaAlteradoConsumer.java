package meta.ecometa.infra.broker.consumer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import meta.ecometa.core.usecase.AlterarPrecoMercadoria;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PrecoMercadoriaAlteradoConsumer {

    private final AlterarPrecoMercadoria alterarPreco;

    @KafkaListener(topics = "${topico.preco.mercadoria.alterado}",
                   groupId = "${spring.kafka.consumer.group-id}",
                   properties = {"spring.json.value.default.type=meta.ecometa.core.usecase.AlterarPrecoMercadoria.In"})
    public void consume(@NonNull final AlterarPrecoMercadoria.In preco) {
        alterarPreco.execute(preco);
    }

}