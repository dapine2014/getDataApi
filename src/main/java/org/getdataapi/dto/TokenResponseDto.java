package org.getdataapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Data
public class TokenResponseDto {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    @JsonProperty("refresh_expires_in")
    private Integer refreshExpiresIn;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("not-before-policy")
    private Integer notBeforePolicy;

    @JsonProperty("scope")
    private String scope;

}
