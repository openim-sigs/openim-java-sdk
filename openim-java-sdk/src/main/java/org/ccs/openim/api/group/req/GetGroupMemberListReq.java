package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import javax.validation.constraints.NotNull;

@Data
public class GetGroupMemberListReq {
    @NotNull
    private String groupID;
    private Integer filter;
    @NotNull
    private RequestPagination pagination;
}
