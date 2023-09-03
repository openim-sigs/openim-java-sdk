package org.ccs.openim.admin.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchAppletReq {
    private RequestPagination pagination;
    private String keyword;
}
