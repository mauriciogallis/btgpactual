package mauricio.sahao.btgpactual.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import mauricio.sahao.btgpactual.config.RabbitMQConfig;
import mauricio.sahao.btgpactual.listener.dto.OrcamentoEvento;
import mauricio.sahao.btgpactual.service.OrcamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class OrcamentoListener {

    private final OrcamentoService orcamentoService;


    @RabbitListener(queues = RabbitMQConfig.ORDER_CREATED_QUEUE)
    public void listen(Message<OrcamentoEvento> message){
        log.info("Mensagem consumida {}", message.getPayload());
        orcamentoService.salvar(message.getPayload());
    }



}
