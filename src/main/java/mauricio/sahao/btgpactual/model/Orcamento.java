package mauricio.sahao.btgpactual.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Document(collection = "orcamento")
public class Orcamento {

    @MongoId
    private Long id;

    @Indexed(name = "id_cliente_index")
    private Long idCliente;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;

    private List<OrcamentoItem> itens;

}
