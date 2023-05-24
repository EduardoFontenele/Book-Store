package spring6api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Integer id;
    private String name;
    private Set<BookDTO> books;
}
