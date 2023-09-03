package org.ccs.openim.api.friend.req;

import lombok.Data;

@Data
public class ApplyToAddFriendReq {
    private String fromUserID;
    private String toUserID;
    private String reqMsg;
    private String ex;
}
