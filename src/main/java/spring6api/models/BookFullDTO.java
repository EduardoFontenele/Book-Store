package spring6api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookFullDTO {
    private Integer id;
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonBackReference
    private AuthorDTO author;
}
