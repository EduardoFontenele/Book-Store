package spring6api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spring6api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
