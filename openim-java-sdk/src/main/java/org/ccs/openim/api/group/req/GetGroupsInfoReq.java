package org.ccs.openim.api.group.req;

import lombok.Data;

import java.util.List;

@Data
public class GetGroupsInfoReq {
    private List<String> groupIDs;
}
