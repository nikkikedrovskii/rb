package com.example.demo.entrypoints.controller.authentication;

import com.example.demo.config.JwtUtils;
import com.example.demo.config.dao.UserDao;
import com.example.demo.entrypoints.model.request.authentication.AuthenticationRequest;
import com.example.demo.entrypoints.model.response.authenticate.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword())
        );
        final UserDetails userDetails = userDao.findUserByEmail(authenticationRequest.getEmail());
        if (userDetails != null) {
           var accessToken = jwtUtils.generateToken(userDetails);
           var response = new AuthenticationResponse();
           response.setAccessToken(accessToken);
           return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
