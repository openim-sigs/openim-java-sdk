package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class GetGroupApplicationListReq {
    private RequestPagination pagination;
    private String fromUserID;
}
