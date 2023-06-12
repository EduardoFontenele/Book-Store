package spring6api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull
    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 255)
    private String name;
}
