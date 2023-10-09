package Kaspi.bank.commentary.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "commentaries")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String commentary;
    private String good;
    private String bad;
}
