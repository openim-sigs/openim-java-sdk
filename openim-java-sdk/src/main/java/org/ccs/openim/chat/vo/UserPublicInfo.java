package org.ccs.openim.chat.vo;

import lombok.Data;

@Data
public class UserPublicInfo {
    private String userID;
    private String account;
    private String email;
    private String nickname;
    private Integer faceURL;
    private Integer gender;
    private Integer level;
}
