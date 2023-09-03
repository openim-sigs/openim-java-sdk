package org.ccs.openim.api.third.req;

import lombok.Data;

@Data
public class FcmUpdateTokenReq {
    private Integer platformID;
    private String fcmToken;
    private String account;
    private Long expireTime;
}
