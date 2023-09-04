package org.ccs.openim.chat.account.req;

import lombok.Data;

@Data
public class ResetPasswordReq {
    private String areaCode;
    private String phoneNumber;
    private String verifyCode;
    private String password;
}
