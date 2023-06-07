package spring6api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    @NotEmpty
    private String name;

    @Column(columnDefinition = "DEFAULT 0")
    private Integer quantity;

    @Digits(integer = 4, fraction = 2)
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "VARCHAR(50)")
    private String main_category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;


}
