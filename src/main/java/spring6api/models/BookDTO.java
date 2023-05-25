package spring6api.models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
>>>>>>> main/modeling

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Integer id;
<<<<<<< HEAD
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @NonNull
    @JsonInclude(JsonInclude.Include.NON_NULL)
=======
    private String name;
>>>>>>> main/modeling
    private AuthorDTO author;
}
