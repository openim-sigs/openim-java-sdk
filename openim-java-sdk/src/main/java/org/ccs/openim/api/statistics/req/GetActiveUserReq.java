package org.ccs.openim.api.statistics.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class GetActiveUserReq {
    private Long start;
    private Long end;
    private Boolean ase;
    private Boolean group;
    @NotNull
    private RequestPagination pagination;
}
