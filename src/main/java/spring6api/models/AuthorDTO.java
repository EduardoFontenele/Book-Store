package spring6api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NonNull
    @NotEmpty
    @Size(max = 255)
    private String name;
}
