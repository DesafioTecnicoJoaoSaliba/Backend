package desafiotecnicojr.desafiotecnico.dtos.authentication.input;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
        @NotNull String email,
        @NotNull String password) {

}
