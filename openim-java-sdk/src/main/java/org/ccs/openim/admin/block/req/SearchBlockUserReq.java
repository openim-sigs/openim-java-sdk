package org.ccs.openim.admin.block.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchBlockUserReq {
    private String keyword;
    private RequestPagination pagination;
}
