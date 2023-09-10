package org.ccs.openim.api.auth.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserTokenReq {
    private String secret;
    private Integer platformID;
    @NotNull
    private String userID;
}
