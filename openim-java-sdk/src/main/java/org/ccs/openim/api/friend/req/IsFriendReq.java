package org.ccs.openim.api.friend.req;

import lombok.Data;

@Data
public class IsFriendReq {
    private String userID1;
    private String userID2;
}
