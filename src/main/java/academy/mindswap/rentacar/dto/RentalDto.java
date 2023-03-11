package academy.mindswap.rentacar.dto;

import academy.mindswap.rentacar.model.Car;
import jakarta.validation.constraints.NotBlank;
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

public class RentalDto {

    @NotBlank(message = "You should have a Start Date")
    private LocalDate startDate;

    @NotBlank(message = "You should have a End Date")
    private LocalDate endDate;

    @NotBlank(message = "You should have a End Date")
    private Long user_id;

    @NotBlank(message = "You should have a End Date")
    private List<Long> carIds;
}
