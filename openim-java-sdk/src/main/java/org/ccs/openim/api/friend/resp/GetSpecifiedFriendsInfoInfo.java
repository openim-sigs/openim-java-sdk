package org.ccs.openim.api.friend.resp;

import lombok.Data;
import org.ccs.openim.api.vo.UserInfo;

@Data
public class GetSpecifiedFriendsInfoInfo {
    private UserInfo userInfo;
    private FriendInfo friendInfo;
    private BlackInfo blackInfo;
}
