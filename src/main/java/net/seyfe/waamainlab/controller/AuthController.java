package net.seyfe.waamainlab.controller;

import net.seyfe.waamainlab.domain.dto.request.LoginRequest;
import net.seyfe.waamainlab.domain.dto.request.RefreshTokenRequest;
import net.seyfe.waamainlab.domain.dto.response.LoginResponse;
import net.seyfe.waamainlab.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }

}
