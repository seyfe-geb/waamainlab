package net.seyfe.waamainlab.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.seyfe.waamainlab.domain.dto.request.LoginRequest;
import net.seyfe.waamainlab.domain.dto.request.RefreshTokenRequest;
import net.seyfe.waamainlab.domain.dto.response.LoginResponse;
import net.seyfe.waamainlab.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getEmail());

        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest, HttpServletResponse response) throws IOException {
        String accessToken = null;
        LoginResponse loginResponse = null;
        try{
            jwtUtil.isTokenExpired(refreshTokenRequest.getRefreshToken());
            var isAccessTokenExpired = jwtUtil.isTokenExpired(refreshTokenRequest.getAccessToken());
            if(isAccessTokenExpired){
                accessToken = jwtUtil.doGenerateToken( jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
                loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            }else{
                System.out.println("ACCESS TOKEN HAS NOT EXPIRED");
                Map<String, String> result = new HashMap<>();
                result.put("Info: ", "ACCESS TOKEN HAS NOT EXPIRED");
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), result);
            }
            return loginResponse;
        }catch(ExpiredJwtException eje){
            try{
                jwtUtil.isTokenExpired(refreshTokenRequest.getRefreshToken());
                accessToken = jwtUtil.doGenerateToken( jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
                loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
                return loginResponse;
            }catch(ExpiredJwtException eje2){
                System.out.println("REFRESH TOKEN EXPIRED, LOGIN AGAIN!");
                Map<String, String> result = new HashMap<>();
                result.put("Error: ", "REFRESH TOKEN EXPIRED, LOGIN AGAIN!");
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), result);
            }
        }
        return new LoginResponse();
    }
}
