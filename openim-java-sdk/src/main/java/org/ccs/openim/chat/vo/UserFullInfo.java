package org.ccs.openim.chat.vo;

import lombok.Data;

@Data
public class UserFullInfo {
    private String userID;
    private String password;
    private String account;
    private String phoneNumber;
    private String areaCode;
    private String email;
    private String nickname;
    private String faceURL;
    private Integer level;
    private Integer gender;
    private Long birth;
    private Integer allowAddFriend;
    private Integer allowBeep;
    private Integer allowVibration;
    private Integer globalRecvMsgOpt;
}
