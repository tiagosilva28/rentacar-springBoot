package academy.mindswap.rentacar.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (nullable = false)
    private String brand;
    @Column (nullable = false)
    private String model;
/*
    @Column (nullable = false)
    private String year;
    @Column (nullable = false, unique = true)
    private String plate;

 */
}
