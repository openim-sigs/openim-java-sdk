package org.ccs.openim.admin.forbidden.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class SearchUserIPLimitLoginReq {
    private String keyword;
    @NotNull
    private RequestPagination pagination;
}
