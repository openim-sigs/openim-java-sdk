package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import javax.validation.constraints.NotNull;

@Data
public class GetGroupApplicationListReq {
    @NotNull
    private String fromUserID;
    @NotNull
    private RequestPagination pagination;
}
