package org.ccs.openim.api.friend.req;

import lombok.Data;
import org.ccs.openim.api.friend.resp.FriendRequest;

import java.util.List;

@Data
public class GetPaginationFriendsApplyFromResp {
    private Integer total;
    private List<FriendRequest> friendRequests;
}
