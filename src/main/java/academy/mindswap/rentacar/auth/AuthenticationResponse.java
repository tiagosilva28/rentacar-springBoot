package academy.mindswap.rentacar.auth;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationResponse {

    private String token;

}
