package spring6api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private Integer id;
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer author_id;
    private Integer quantity = 0;
    private BigDecimal price = new BigDecimal(0);
    private String author;
    private String description = "Descrição indisponível";
    private String category = "Não informada";
}

