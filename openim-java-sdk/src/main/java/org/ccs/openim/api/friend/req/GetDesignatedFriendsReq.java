package org.ccs.openim.api.friend.req;

import lombok.Data;

import java.util.List;

@Data
public class GetDesignatedFriendsReq {
    private String ownerUserID;
    private List<String> friendUserIDs;
}
