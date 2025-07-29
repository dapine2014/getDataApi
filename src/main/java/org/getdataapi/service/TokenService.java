package org.getdataapi.service;

import lombok.RequiredArgsConstructor;
import org.getdataapi.dto.TokenResponseDto;
import org.getdataapi.service.api.GetTocken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final GetTocken getTocken;

    public TokenResponseDto obtainToken() {
        String formBody = String.format("grant_type=%s&client_id=%s&client_secret=%s",
                "client_credentials",
                "86cb7eb8",
                "e0ca69dc260b12536cd8464a7195607f");

        TokenResponseDto dto =  getTocken.getToken(formBody);
      return dto;
    }
}
