package org.ccs.openim.api.friend.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import javax.validation.constraints.NotNull;

@Data
public class GetPaginationFriendsReq {
    @NotNull
    private String userID;
    @NotNull
    private RequestPagination pagination;

}
