package org.getdataapi.service;

import lombok.RequiredArgsConstructor;
import org.getdataapi.config.GetTocken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final GetTocken getTocken;


    @Value("${token.client.id}")
    private String clientId;

    @Value("${token.client.secret}")
    private String clientSecret;

}
