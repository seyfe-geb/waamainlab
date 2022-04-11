package net.seyfe.waamainlab.service;


import net.seyfe.waamainlab.domain.dto.request.LoginRequest;
import net.seyfe.waamainlab.domain.dto.request.RefreshTokenRequest;
import net.seyfe.waamainlab.domain.dto.response.LoginResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest, HttpServletResponse response) throws IOException;
}
