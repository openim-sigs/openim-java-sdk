package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class GetGroupMemberListReq {
    private RequestPagination pagination;
    private String groupID;
    private Integer filter;
}
