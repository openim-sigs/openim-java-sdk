package org.ccs.openim.api.statistics.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class GetActiveGroupReq {
    private Long start;
    private Long end;
    private Boolean ase;
    @NotNull
    private RequestPagination pagination;
}
