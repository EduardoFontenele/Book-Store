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
    @NotEmpty
    private Integer id;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    @NotEmpty
    private String name;

    @Column(columnDefinition = "DEFAULT 0")
    private Integer quantity;

    @Column(columnDefinition = "DECIMAL(4,2)")
    private BigDecimal price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "VARCHAR(50)", name = "main_category")
    private String mainCategory;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;


}
