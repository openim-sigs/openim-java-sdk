package org.ccs.openim.api.group.req;

import lombok.Data;

@Data
public class MuteGroupMemberReq {
    private String groupID;
    private String userID;
    private Integer mutedSeconds;
}
