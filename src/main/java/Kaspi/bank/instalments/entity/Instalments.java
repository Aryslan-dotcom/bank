package Kaspi.bank.instalments.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instalments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Instalments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer months;

}
