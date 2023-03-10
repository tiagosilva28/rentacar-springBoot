package academy.mindswap.rentacar.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rentals")
public class Rental {

    @ManyToMany(targetEntity = Car.class ,fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Car> cars = new ArrayList<>();

    @ManyToOne(targetEntity = User.class ,fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private LocalDate startDate;

    @Column (nullable = false)
    private LocalDate endDate;



}
