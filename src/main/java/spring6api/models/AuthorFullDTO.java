package spring6api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class AuthorFullDTO {
    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NonNull
    @NotEmpty
    @Size(max = 255)
    private String name;
    @JsonManagedReference
    private Set<BookDTO> books = new HashSet<>();
}
