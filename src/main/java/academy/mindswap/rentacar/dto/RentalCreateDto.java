package academy.mindswap.rentacar.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    private Long userId;

    @NotBlank(message = "You should have a End Date")
    private List<Long> carIds;


}
