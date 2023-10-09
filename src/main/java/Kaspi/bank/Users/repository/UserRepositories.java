package Kaspi.bank.Users.repository;

import Kaspi.bank.Users.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepositories extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
    Users findAllById(Long id);
}
