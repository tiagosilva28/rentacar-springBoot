package academy.mindswap.rentacar.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return Objects.equals(brand, carDto.brand) && Objects.equals(model, carDto.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }
}
