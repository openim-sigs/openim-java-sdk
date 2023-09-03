package org.ccs.openim.admin.resp;

import lombok.Data;

@Data
public class GetAdminInfoResp {

    private String account;
    private String password;
    private String faceURL;
    private String nickname;

    private String userID;
    private Integer level;
    private Long createTime;
}
