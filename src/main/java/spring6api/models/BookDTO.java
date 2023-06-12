package spring6api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private Integer id;

    @NotNull(message = "Name cannot be null")
    @Size(max = 255)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @NotNull(message = "Author ID cannot be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer author_id;

    @Min(value = 0, message = "Quantity can't have a negative value")
    private Integer quantity;

    @Digits(integer = 4, fraction = 2)
    @DecimalMin(value = "0.0", message = "Price can't have a negative value")
    private BigDecimal price;

    private String author;

    private String description;

    private String category;
}

