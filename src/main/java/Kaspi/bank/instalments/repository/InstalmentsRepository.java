package Kaspi.bank.instalments.repository;

import Kaspi.bank.instalments.entity.Instalments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface InstalmentsRepository extends JpaRepository<Instalments,Long> {
}
