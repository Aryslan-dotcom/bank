package Kaspi.bank.phone.entities;
import Kaspi.bank.color.entity.Color;
import Kaspi.bank.commentary.entity.Commentary;
import Kaspi.bank.image.entity.Images;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "items_phone")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description_phone;
    private String price;
    private String memoryPhones;
    private String brandPhones;
    private String characteristicPhones;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Images>imagesList;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Color>colors;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Commentary>commentaryPhones;
}
