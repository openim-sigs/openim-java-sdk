package org.ccs.openim.api.friend.req;

import lombok.Data;

import java.util.List;

@Data
public class UpdateFriendsReq {
    private String ownerUserID;
    private List<String> friendUserIDs;
    private Boolean isPinned;
    private String remark;
    private String ex;
}
