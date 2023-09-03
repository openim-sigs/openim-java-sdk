package org.ccs.openim.api.friend.req;

import lombok.Data;

@Data
public class DeleteFriendReq {
    private String ownerUserID;
    private String friendUserID;
}
