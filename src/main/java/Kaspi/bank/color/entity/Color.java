package Kaspi.bank.color.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "colors")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
