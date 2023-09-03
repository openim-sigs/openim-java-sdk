package org.ccs.openim.api.friend.req;

import lombok.Data;

@Data
public class SetFriendRemarkReq {
    private String ownerUserID;
    private String friendUserID;
    private String remark;
}
