package org.ccs.openim.api.friend.resp;

import lombok.Data;

@Data
public class IsFriendResp {
    /**
     * 如果userID2在userID1的好友列表中 true
     */
    private boolean inUser1Friends;
    /**
     * 如果userID1在userID2的好友列表中 true
     */
    private boolean inUser2Friends;

}
