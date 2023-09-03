package org.ccs.openim.admin.resp;

import lombok.Data;

@Data
public class AdminLoginResp {
    private String adminAccount;
    private String adminToken;
    private String nickname;
    private String faceURL;
    private Integer level;
    private String adminUserID;

    private String imToken;
    private String imUserID;

}
