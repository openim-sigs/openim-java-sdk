package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class GetGroupsReq {
    private RequestPagination pagination;
    private String groupName;
    private String groupID;
}
