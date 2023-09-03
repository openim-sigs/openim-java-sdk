package org.ccs.openim.api.group.req;

import lombok.Data;

import java.util.List;

@Data
public class GetGroupUsersReqApplicationListReq {
    private String groupID;
    private List<String> userIDs;
}
