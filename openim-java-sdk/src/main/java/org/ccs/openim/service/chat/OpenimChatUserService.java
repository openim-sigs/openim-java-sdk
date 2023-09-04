package org.ccs.openim.service.chat;

import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.chat.OpenImChatUserRest;
import org.ccs.openim.chat.user.req.*;
import org.ccs.openim.chat.user.resp.FindUserFullInfoResp;
import org.ccs.openim.chat.user.resp.FindUserPublicInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserFullInfoResp;
import org.ccs.openim.chat.user.resp.SearchUserPubliclInfoResp;


public class OpenimChatUserService {
    private OpenImChatUserRest openImChatUserRest = new OpenImChatUserRest();


    /**
     * 编辑个人资料
     * routePath=/user/update
     *
     * @param openImToken
     * @param req
     * @return
     */
    public OpenImResult<String> updateUserInfo(OpenImToken openImToken, UpdateUserInfoReq req) {
        return openImChatUserRest.updateUserInfo(openImToken, req);
    }

    /**
     * 获取用户所有信息
     * routePath=/user/find/full
     *
     * @param req
     * @return
     */
    public OpenImResult<FindUserFullInfoResp> findUserFullInfo(OpenImToken openImToken, FindUserFullInfoReq req) {
        return openImChatUserRest.findUserFullInfo(openImToken, req);
    }

    /**
     * 获取用户公开信息
     * routePath=/user/find/public
     *
     * @param req
     * @return
     */
    public OpenImResult<FindUserPublicInfoResp> findUserPublicInfo(OpenImToken openImToken, FindUserPublicInfoReq req) {
        return openImChatUserRest.findUserPublicInfo(openImToken, req);
    }

    /**
     * 搜索用户所有信息
     * routePath=/user/search/full
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchUserFullInfoResp> searchUserFullInfo(OpenImToken openImToken, SearchUserFullInfoReq req) {
        return openImChatUserRest.searchUserFullInfo(openImToken, req);
    }

    /**
     * 搜索用户公开信息
     * routePath=/user/search/public
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchUserPubliclInfoResp> searchUserPublicInfo(OpenImToken openImToken, SearchUserPublicInfoReq req) {
        return openImChatUserRest.searchUserPublicInfo(openImToken, req);
    }
}
