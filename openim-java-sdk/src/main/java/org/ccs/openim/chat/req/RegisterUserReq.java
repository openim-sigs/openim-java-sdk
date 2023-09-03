package org.ccs.openim.chat.req;

import lombok.Data;

@Data
public class RegisterUserReq {
    private String invitationCode;
    private String verifyCode;
    private String ip;
    private String deviceID;
    private boolean autoLogin;
    private Integer platform;

    private RegisterUserInfo user;
}
