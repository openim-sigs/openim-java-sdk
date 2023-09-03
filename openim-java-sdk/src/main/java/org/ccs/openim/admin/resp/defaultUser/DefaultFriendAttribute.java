package org.ccs.openim.admin.resp.defaultUser;

import lombok.Data;
import org.ccs.openim.chat.vo.UserPublicInfo;

@Data
public class DefaultFriendAttribute {
    private String userID;
    private Long createTime;
    private UserPublicInfo user;
}
