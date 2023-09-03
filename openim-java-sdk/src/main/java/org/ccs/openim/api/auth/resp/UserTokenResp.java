package org.ccs.openim.api.auth.resp;

import lombok.Data;

@Data
public class UserTokenResp {
    private String token;
    private Long expireTimeSeconds;
}
