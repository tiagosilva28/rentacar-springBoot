package academy.mindswap.rentacar.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class CarDto {

    @NotBlank(message = "Must have a Brand")
    private String brand;

    @NotBlank(message = "Must have a Model")
    private String model;
}
