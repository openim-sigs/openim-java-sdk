package org.ccs.openim.chat.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chenjh
 */
@Data
public class LoginReq implements Serializable {
    private String areaCode;
    private String phoneNumber;
    private String account;
    private String password;
    private String verifyCode;
    private String deviceID;
    private Integer platform;
    private String ip;
}
