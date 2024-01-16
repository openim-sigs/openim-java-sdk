package org.ccs.openim.chat.friend.req;

import lombok.Data;
import org.ccs.openim.chat.req.SearchUserInfoReq;

@Data
public class SearchFriendReq extends SearchUserInfoReq {
    private String userID;
}
