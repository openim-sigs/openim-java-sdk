package org.ccs.openim.admin.req.defaultUser;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchDefaultFriendReq {
    private RequestPagination pagination;
    private String keyword;
}
