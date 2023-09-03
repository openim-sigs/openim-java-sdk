package org.ccs.openim.chat.req;

import lombok.Data;

@Data
public class VerifyCodeReq {
    private String areaCode;
    private String phoneNumber;
    private String verifyCode;
}
