package org.ccs.openim.api.vo;

import lombok.Data;

@Data
public class UserInfoWithEx {
    private String userID;
    private String nickname;
    private String faceURL;
    private String ex;
    private Integer globalRecvMsgOpt;
}
