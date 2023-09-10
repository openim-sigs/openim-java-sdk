package org.ccs.openim.chat.user.req;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UpdateUserInfoReq {
    @NotNull

    private String userID;
    private String account;
    private String phoneNumber;
    private String areaCode;
    @Email
    private String email;

    private String nickname;
    private String faceURL;
    private Integer gender;
    private Integer level;
    private Long birth;

    private Integer allowAddFriend;
    private Integer allowBeep;
    private Integer allowVibration;
    private Integer globalRecvMsgOpt;
}
