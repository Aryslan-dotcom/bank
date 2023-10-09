package Kaspi.bank.image.repository;

import Kaspi.bank.image.entity.Images;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ImagesRepository extends JpaRepository<Images,Long> {
}
