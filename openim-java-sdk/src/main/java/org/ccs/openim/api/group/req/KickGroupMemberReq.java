package org.ccs.openim.api.group.req;

import lombok.Data;

import java.util.List;

@Data
public class KickGroupMemberReq {
    private String groupID;
    private List<String> kickedUserIDs;
    private String reason;
}
