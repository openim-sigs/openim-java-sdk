package org.ccs.openim.api.statistics.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class GetActiveGroupReq {
    private Long start;
    private Long end;
    private Boolean ase;
    private RequestPagination pagination;
}
