package org.ccs.openim.admin.block.resp;

import lombok.Data;

@Data
public class BlockUserInfo {
    private String userID;
    private String account;
    private String phoneNumber;
    private String areaCode;
    private String email;
    private String nickname;
    private String faceURL;
    private Integer gender;
    private String reason;
    private String opUserID;
    private Long createTime;
}
