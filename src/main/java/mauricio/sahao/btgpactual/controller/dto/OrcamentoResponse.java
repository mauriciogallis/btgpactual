package mauricio.sahao.btgpactual.controller.dto;

import mauricio.sahao.btgpactual.model.Orcamento;

import java.math.BigDecimal;

public record OrcamentoResponse(Long id,
                                Long clienteId,
                                BigDecimal total) {

    public static OrcamentoResponse fromEntity(Orcamento orcamento) {
        return new OrcamentoResponse(orcamento.getId(),orcamento.getIdCliente(),orcamento.getTotal());
    }
}
