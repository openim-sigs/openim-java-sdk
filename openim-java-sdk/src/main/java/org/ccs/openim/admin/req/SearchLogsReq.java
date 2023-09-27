package org.ccs.openim.admin.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class SearchLogsReq {
    private String keyword;
    private Long startTime;
    private Long endTime;
    @NotNull
    private RequestPagination pagination;
}
