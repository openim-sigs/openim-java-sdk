package org.ccs.openim.service.chat;


import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.chat.OpenImChatFriendRest;
import org.ccs.openim.chat.friend.req.SearchFriendReq;
import org.ccs.openim.chat.resp.SearchUserInfoResp;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImChatFriendService {
    private OpenImChatFriendRest openImChatFriendRest = new OpenImChatFriendRest();


    /**
     * routePath = /friend/search
     *
     * @param openImToken
     * @param req
     * @return
     */
    public OpenImResult<SearchUserInfoResp> searchFriend(OpenImToken openImToken, SearchFriendReq req) {
        ValidatorUtils.validate(req);
        return openImChatFriendRest.searchFriend(openImToken, req);
    }
}
