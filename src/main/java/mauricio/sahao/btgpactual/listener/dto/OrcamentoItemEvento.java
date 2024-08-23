package mauricio.sahao.btgpactual.listener.dto;

import java.math.BigDecimal;

public record OrcamentoItemEvento(String produto,
                                  Integer quantidade,
                                  BigDecimal preco) {
}
