package academy.mindswap.rentacar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class RentalCreateDto {

    @NotBlank(message = "You should have a Start Date")
    private LocalDate startDate;

    @NotBlank(message = "You should have a End Date")
    private LocalDate endDate;

    @NotBlank(message = "You should have a End Date")
    private Long user_id;

    @NotBlank(message = "You should have a End Date")
    private Long car_id;


}
