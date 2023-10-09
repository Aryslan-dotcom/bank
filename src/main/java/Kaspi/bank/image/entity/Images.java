package Kaspi.bank.image.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "images")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String link;
}
