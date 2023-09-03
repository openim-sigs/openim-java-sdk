package org.ccs.openim.admin.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchLogsReq {
    private RequestPagination pagination;
    private String keyword;
    private Long startTime;
    private Long endTime;
}
