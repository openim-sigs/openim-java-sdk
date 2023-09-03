package org.ccs.openim.api.friend.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetPaginationFriendsResp {
    private Integer total;
    private List<FriendInfo> friendsInfo;
}
