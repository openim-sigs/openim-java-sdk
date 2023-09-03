package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class GetUserReqApplicationListReq {
    private RequestPagination pagination;
    private String userID;
}
