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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "rentals_cars",
            joinColumns = {@JoinColumn(name = "rental_id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private List<Car> cars = new ArrayList<>();


    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private User user;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;


    public void addCar(Car car) {
        this.cars.add(car);
        car.getRentals().add(this);
    }

    public void removeCar(long carId) {
        Car car = this.cars.stream().filter(t -> t.getId() == carId).findFirst().orElse(null);
        if (car != null) {
            this.cars.remove(car);
            car.getRentals().remove(this);
        }
    }


}
