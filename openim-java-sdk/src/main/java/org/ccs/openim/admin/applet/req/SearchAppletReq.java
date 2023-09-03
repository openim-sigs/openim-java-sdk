package org.ccs.openim.admin.applet.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchAppletReq {
    private RequestPagination pagination;
    private String keyword;
}
