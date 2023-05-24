package spring6api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Integer id;
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AuthorDTO author;
}
