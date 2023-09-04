package org.ccs.openim.chat.account.req;

import lombok.Data;

/**
 * @author chenjh
 */
@Data
public class RegisterUserInfo {
    private String userID;
    private String nickname;
    private String faceURL;
    private String areaCode;
    private String phoneNumber;
    private String email;
    private String account;
    private String password;
    private Long birth;
    private Integer gender;
}
