package org.ccs.openim.admin.defaultGroup.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchDefaultGroupReq {
    private String keyword;
    private RequestPagination pagination;
}
