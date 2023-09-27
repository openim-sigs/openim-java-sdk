package org.ccs.openim.api.friend.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class GetPaginationBlacksReq {
    @NotNull
    private String userID;
    @NotNull
    private RequestPagination pagination;
}
