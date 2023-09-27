package org.ccs.openim.admin.defaultUser.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class SearchDefaultFriendReq {
    private String keyword;
    @NotNull
    private RequestPagination pagination;
}
