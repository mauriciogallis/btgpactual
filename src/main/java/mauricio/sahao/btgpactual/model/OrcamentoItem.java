package mauricio.sahao.btgpactual.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrcamentoItem {

    private String produto;

    private Integer quantidade;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal preco;

}
