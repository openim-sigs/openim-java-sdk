package org.ccs.openim.api.friend.req;

import lombok.Data;

@Data
public class GetDesignatedFriendsApplyReq {
    private String fromUserID;
    private String toUserID;
}
