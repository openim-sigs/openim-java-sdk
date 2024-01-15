package org.ccs.openim.api.user.req;

import lombok.Data;

@Data
public class UpdateNotificationAccountInfoReq {
    private String userID;
    private String nickName;
    private String faceURL;
}
