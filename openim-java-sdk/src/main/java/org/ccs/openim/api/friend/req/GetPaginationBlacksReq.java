package org.ccs.openim.api.friend.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class GetPaginationBlacksReq {
    private String userID;
    private RequestPagination pagination;
}
