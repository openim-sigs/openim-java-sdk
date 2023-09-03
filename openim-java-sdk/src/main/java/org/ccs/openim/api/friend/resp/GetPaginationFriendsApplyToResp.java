package org.ccs.openim.api.friend.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetPaginationFriendsApplyToResp {
    private Integer total;
    private List<FriendRequest> FriendRequests;
}
