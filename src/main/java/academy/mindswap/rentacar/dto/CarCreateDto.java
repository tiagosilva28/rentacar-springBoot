package academy.mindswap.rentacar.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarCreateDto {

    @NotBlank (message = "Must have a Brand")
    private String brand;

    @NotBlank (message = "Must have a Model")
    private String model;


}
