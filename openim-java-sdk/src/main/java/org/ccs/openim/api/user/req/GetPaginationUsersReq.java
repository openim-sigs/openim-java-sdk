package org.ccs.openim.api.user.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import javax.validation.constraints.NotNull;

@Data
public class GetPaginationUsersReq {
    @NotNull
    private RequestPagination pagination;
}
