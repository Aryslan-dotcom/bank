package Kaspi.bank.category.repository;
import Kaspi.bank.category.entity.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CategoryItemRepository extends JpaRepository<Category,Long> {
    Category findAllById(Long id);
}
