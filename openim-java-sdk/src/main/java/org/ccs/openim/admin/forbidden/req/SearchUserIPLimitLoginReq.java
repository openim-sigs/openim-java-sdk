package org.ccs.openim.admin.forbidden.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchUserIPLimitLoginReq {
    private String keyword;
    private RequestPagination pagination;
}
