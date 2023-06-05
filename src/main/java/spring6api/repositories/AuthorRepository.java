package spring6api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring6api.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Modifying
    @Query("update Author author set author.name = :name where author.id = :id")
    void updateName(@Param("id") Integer id,@Param("name") String name);
}
