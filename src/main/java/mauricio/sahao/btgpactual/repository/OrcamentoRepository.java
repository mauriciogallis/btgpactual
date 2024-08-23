package mauricio.sahao.btgpactual.repository;

import mauricio.sahao.btgpactual.model.Orcamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrcamentoRepository extends MongoRepository<Orcamento, Long> {
    Page<Orcamento> findAllByIdCliente(Long idCliente, PageRequest pageRequest);
}
