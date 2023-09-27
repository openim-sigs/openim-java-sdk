package org.ccs.openim.admin.defaultGroup.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class SearchDefaultGroupReq {
    private String keyword;
    @NotNull
    private RequestPagination pagination;
}
