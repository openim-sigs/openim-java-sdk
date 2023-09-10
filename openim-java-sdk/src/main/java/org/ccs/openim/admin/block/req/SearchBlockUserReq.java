package org.ccs.openim.admin.block.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import javax.validation.constraints.NotNull;

@Data
public class SearchBlockUserReq {
    private String keyword;
    @NotNull
    private RequestPagination pagination;
}
