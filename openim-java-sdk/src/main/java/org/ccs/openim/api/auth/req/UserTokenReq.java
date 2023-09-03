package org.ccs.openim.api.auth.req;

import lombok.Data;

@Data
public class UserTokenReq {
    private String secret;
    private Integer platformID;
    private String userID;
}
