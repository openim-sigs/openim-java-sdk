package org.ccs.openim.api.user.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class GetPaginationUsersReq {
    private RequestPagination pagination;
}
