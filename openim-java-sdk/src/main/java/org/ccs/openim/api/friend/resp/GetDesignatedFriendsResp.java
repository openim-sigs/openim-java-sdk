package org.ccs.openim.api.friend.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetDesignatedFriendsResp {
    private List<FriendInfo> friendsInfo;
}
