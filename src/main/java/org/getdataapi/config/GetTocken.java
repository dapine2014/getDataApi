package org.getdataapi.config;

import feign.Headers;
import org.getdataapi.dto.TokenResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "get-tocken", url = "https://keycloak-sso-app.apps.openshift4.positiva.gov.co/auth/realms/apis-prod/protocol/openid-connect/token")
public interface GetTocken {

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    TokenResponseDto getToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("client_secret") String clientSecret
    );
}
