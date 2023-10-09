package Kaspi.bank.seller.entity;

import Kaspi.bank.phone.entities.ItemPhone;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "sellers")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String number;
    @ManyToOne(fetch = FetchType.EAGER)
    private ItemPhone itemPhone;
}
