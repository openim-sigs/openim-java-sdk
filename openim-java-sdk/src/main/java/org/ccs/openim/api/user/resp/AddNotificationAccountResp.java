package org.ccs.openim.api.user.resp;

import lombok.Data;

@Data
public class AddNotificationAccountResp {
    private String userID;
    private String nickName;
    private String faceURL;
}
