package desafiotecnicojr.desafiotecnico.service;


import desafiotecnicojr.desafiotecnico.dtos.authentication.AuthenticationRequest;
import desafiotecnicojr.desafiotecnico.dtos.authentication.AuthenticationResponse;
import desafiotecnicojr.desafiotecnico.dtos.register.RegisterRequest;
import desafiotecnicojr.desafiotecnico.entity.user.User;
import desafiotecnicojr.desafiotecnico.repositories.user.UserRepository;
import desafiotecnicojr.desafiotecnico.util.JwtUtil;
import enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User();
        user.setName(request.name().trim());
        user.setEmail(request.email().trim());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(UserRole.ROLE_ADMIN);
        user.setCreatedDate(Instant.now());
        user.setModifiedDate(Instant.now());
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()));
        User user = userRepository.findByEmail(request.email()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

}
