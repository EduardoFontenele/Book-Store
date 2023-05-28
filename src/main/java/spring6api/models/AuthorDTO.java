package spring6api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;

@Data
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

    @JsonIgnore
    private Set<BookDTO> books = new HashSet<>();
}
