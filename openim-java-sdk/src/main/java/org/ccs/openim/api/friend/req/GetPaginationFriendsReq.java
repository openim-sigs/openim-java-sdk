package org.ccs.openim.api.friend.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class GetPaginationFriendsReq {
    private RequestPagination pagination;
    private String userID;

}
