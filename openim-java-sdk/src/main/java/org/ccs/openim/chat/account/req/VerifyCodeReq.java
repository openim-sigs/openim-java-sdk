package org.ccs.openim.chat.account.req;

import lombok.Data;

@Data
public class VerifyCodeReq {
    private String areaCode;
    private String phoneNumber;
    private String verifyCode;
}
