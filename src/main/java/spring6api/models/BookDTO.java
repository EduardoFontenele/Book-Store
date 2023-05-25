package spring6api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
    private Integer id;
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    private AuthorDTO author;
}
