package mauricio.sahao.btgpactual.service;

import lombok.RequiredArgsConstructor;
import mauricio.sahao.btgpactual.controller.dto.OrcamentoResponse;
import mauricio.sahao.btgpactual.listener.dto.OrcamentoEvento;
import mauricio.sahao.btgpactual.model.Orcamento;
import mauricio.sahao.btgpactual.model.OrcamentoItem;
import mauricio.sahao.btgpactual.repository.OrcamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;

    public void salvar(OrcamentoEvento dto){

        var orcamento = new Orcamento();
        orcamento.setId(dto.codigoPedido());
        orcamento.setIdCliente(dto.codigoCliente());
        orcamento.setItens(getItens(dto));
        orcamento.setTotal(getTotal(dto));

        orcamentoRepository.save(orcamento);
    }

    private static List<OrcamentoItem> getItens(OrcamentoEvento dto) {
        return dto.itens().stream()
                .map(i -> new OrcamentoItem(i.produto(), i.quantidade(), i.preco())).toList();
    }

    private static BigDecimal getTotal(OrcamentoEvento dto) {
        return dto.itens().stream()
                .map(i -> BigDecimal.valueOf(i.quantidade()).multiply(i.preco()))
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public Page<OrcamentoResponse> findAll(Long idCliente, PageRequest pageRequest) {
        Page<Orcamento> orcamentos =  orcamentoRepository.findAllByIdCliente(idCliente,pageRequest);

        return orcamentos.map(OrcamentoResponse::fromEntity);
    }


}
