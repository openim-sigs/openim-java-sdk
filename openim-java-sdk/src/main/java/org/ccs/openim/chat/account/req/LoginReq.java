package org.ccs.openim.chat.account.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author chenjh
 */
@Data
public class LoginReq implements Serializable {
    private String areaCode;
    @NotNull
    private String phoneNumber;
    private String account;
    @NotNull
    private String password;
    private String verifyCode;
    private String deviceID;
    private Integer platform;
    private String ip;
}
