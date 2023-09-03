package org.ccs.openim.chat.req;

import lombok.Data;

@Data
public class SendVerifyCodeReq {
    private Integer usedFor;
    private String ip;
    private String invitationCode;
    private String deviceID;
    private Integer platform;
    private String areaCode;
    private String phoneNumber;
}
