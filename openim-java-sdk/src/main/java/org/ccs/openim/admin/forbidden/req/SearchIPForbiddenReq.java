package org.ccs.openim.admin.forbidden.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchIPForbiddenReq {
    private String keyword;
    private Integer status;
    private RequestPagination pagination;
}
