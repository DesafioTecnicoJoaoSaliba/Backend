package desafiotecnicojr.desafiotecnico.dtos.authentication;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
        @NotNull String email,
        @NotNull String password) {

}
