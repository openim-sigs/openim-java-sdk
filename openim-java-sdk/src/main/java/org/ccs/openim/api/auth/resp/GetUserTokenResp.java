package org.ccs.openim.api.auth.resp;

import lombok.Data;

@Data
public class GetUserTokenResp {
    private String token;
    private Long expireTimeSeconds;
}
