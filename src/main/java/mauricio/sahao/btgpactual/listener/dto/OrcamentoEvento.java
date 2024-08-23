package mauricio.sahao.btgpactual.listener.dto;

import java.util.List;

public record OrcamentoEvento(Long codigoPedido,
                              Long codigoCliente,
                              List<OrcamentoItemEvento> itens) {



}
