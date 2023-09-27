package org.ccs.openim.admin.forbidden.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class SearchIPForbiddenReq {
    private String keyword;
    private Integer status;
    @NotNull
    private RequestPagination pagination;
}
