package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import javax.validation.constraints.NotNull;

@Data
public class GetUserReqApplicationListReq {
    @NotNull
    private String userID;
    @NotNull
    private RequestPagination pagination;
}
