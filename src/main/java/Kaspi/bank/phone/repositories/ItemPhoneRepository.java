package Kaspi.bank.phone.repositories;

import Kaspi.bank.phone.entities.ItemPhone;
import Kaspi.bank.price.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPhoneRepository extends JpaRepository<ItemPhone,Long> {
    ItemPhone findAllById(Long id);
    List<ItemPhone> findAllByNameContainsIgnoreCase(String name);
    List<ItemPhone> findAllByPriceBetween(Price min, Price max);
    List<ItemPhone> findAllByNameContainsIgnoreCaseAndPriceLessThan(String name, Price max);
    List<ItemPhone> findAllByNameContainsIgnoreCaseAndPriceGreaterThan(String name,Price min);
    List<ItemPhone> findAllByNameContainsIgnoreCaseAndPriceBetween(String name, Price min, Price max);
    List<ItemPhone> findAllByPriceGreaterThan(Price min);
    List<ItemPhone> findAllByPriceLessThan(Price max);
}
