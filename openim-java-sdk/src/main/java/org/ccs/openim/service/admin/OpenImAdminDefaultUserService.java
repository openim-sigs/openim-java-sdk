package org.ccs.openim.service.admin;

import org.ccs.openim.admin.OpenImAdminDefaultUserRest;
import org.ccs.openim.admin.defaultUser.req.AddDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.req.DelDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.req.FindDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.req.SearchDefaultFriendReq;
import org.ccs.openim.admin.defaultUser.resp.FindDefaultFriendResp;
import org.ccs.openim.admin.defaultUser.resp.SearchDefaultFriendResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImAdminDefaultUserService {

    private OpenImAdminDefaultUserRest openImAdminDefaultUserRest = new OpenImAdminDefaultUserRest();


    /**
     * 添加注册时默认好友
     * routePath=/default/user/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addDefaultFriend(OpenImToken openImToken, AddDefaultFriendReq req) {
        ValidatorUtils.validate(req);
        return openImAdminDefaultUserRest.addDefaultFriend(openImToken, req);
    }

    /**
     * 删除注册时默认好友
     * routePath=/default/user/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delDefaultFriend(OpenImToken openImToken, DelDefaultFriendReq req) {
        ValidatorUtils.validate(req);
        return openImAdminDefaultUserRest.delDefaultFriend(openImToken, req);
    }

    /**
     * 默认好友列表
     * routePath=/default/user/find
     *
     * @param req
     * @return
     */
    public OpenImResult<FindDefaultFriendResp> findDefaultFriend(OpenImToken openImToken, FindDefaultFriendReq req) {
        ValidatorUtils.validate(req);
        return openImAdminDefaultUserRest.findDefaultFriend(openImToken, req);
    }

    /**
     * 搜索注册时默认好友列表
     * routePath=/default/user/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchDefaultFriendResp> searchDefaultFriend(OpenImToken openImToken, SearchDefaultFriendReq req) {
        ValidatorUtils.validate(req);
        return openImAdminDefaultUserRest.searchDefaultFriend(openImToken, req);
    }

}
