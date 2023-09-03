package org.ccs.openim.api.group.req;

import lombok.Data;

@Data
public class CancelMuteGroupMemberReq {
    private String groupID;
    private String userID;
}
