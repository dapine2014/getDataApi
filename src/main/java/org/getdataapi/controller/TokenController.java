package org.getdataapi.controller;

import lombok.RequiredArgsConstructor;
import org.getdataapi.dto.TokenResponseDto;
import org.getdataapi.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    @GetMapping("/token")
    public ResponseEntity<TokenResponseDto> getToken() {
        TokenResponseDto response = tokenService.obtainToken();
        return ResponseEntity.ok(response);
    }

}
