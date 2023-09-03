package org.ccs.openim.api.statistics.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class GetActiveUserReq {
    private Long start;
    private Long end;
    private Boolean ase;
    private Boolean group;
    private RequestPagination pagination;
}
