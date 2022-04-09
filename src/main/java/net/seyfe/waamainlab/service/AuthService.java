package net.seyfe.waamainlab.service;


import net.seyfe.waamainlab.domain.dto.request.LoginRequest;
import net.seyfe.waamainlab.domain.dto.request.RefreshTokenRequest;
import net.seyfe.waamainlab.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
