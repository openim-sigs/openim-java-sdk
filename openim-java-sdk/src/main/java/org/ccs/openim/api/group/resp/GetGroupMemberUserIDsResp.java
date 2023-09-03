package org.ccs.openim.api.group.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetGroupMemberUserIDsResp {
    private List<String> userIDs;
}
