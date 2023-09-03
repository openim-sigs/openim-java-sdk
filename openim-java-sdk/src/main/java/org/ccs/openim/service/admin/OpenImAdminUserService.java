package org.ccs.openim.service.admin;

import org.ccs.openim.admin.OpenImAdminRest;
import org.ccs.openim.admin.req.*;
import org.ccs.openim.admin.req.defaultUser.AddDefaultFriendReq;
import org.ccs.openim.admin.req.defaultUser.DelDefaultFriendReq;
import org.ccs.openim.admin.req.defaultUser.FindDefaultFriendReq;
import org.ccs.openim.admin.req.defaultUser.SearchDefaultFriendReq;
import org.ccs.openim.admin.resp.*;
import org.ccs.openim.admin.resp.defaultUser.FindDefaultFriendResp;
import org.ccs.openim.admin.resp.defaultUser.SearchDefaultFriendResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.chat.req.UpdateUserInfoReq;
import org.ccs.openim.chat.resp.GetClientConfigResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImAdminUserService {
    @Resource
    private OpenImAdminRest openImAdminRest;

    /**
     * 登入
     * routePath=/account/login
     *
     * @param loginReq
     * @return
     */
    public OpenImResult<AdminLoginResp> login(LoginReq loginReq, String operationid) {
        return openImAdminRest.login(loginReq, operationid);
    }

    /**
     * 获取管理员信息
     * routePath=/account/info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetAdminInfoResp> info(OpenImToken openImToken, GetAdminInfoReq req) {
        return openImAdminRest.info(openImToken, req);
    }

    /**
     * 修改信息
     * routePath=/account/update
     *
     * @param req
     * @return
     */
    public OpenImResult<String> update(OpenImToken openImToken, UpdateUserInfoReq req) {
        return openImAdminRest.update(openImToken, req);
    }

    /**
     * 获取客户端初始化配置
     * routePath=/client_config/get
     *
     * @return
     */
    public OpenImResult<GetClientConfigResp> getClientConfig(OpenImToken openImToken) {
        return openImAdminRest.getClientConfig(openImToken);
    }

    /**
     * 设置客户端初始化配置
     * routePath=/client_config/set
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setClientConfig(OpenImToken openImToken, SetClientConfigReq req) {
        return openImAdminRest.setClientConfig(openImToken, req);
    }

    /**
     * 删除客户端初始化配置
     * routePath=/client_config/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delClientConfig(OpenImToken openImToken, DelClientConfigReq req) {
        return openImAdminRest.delClientConfig(openImToken, req);
    }


    /**
     * 添加注册时默认好友
     *
     * @param req
     * @return
     */
    public OpenImResult<String> defaultUserAdd(OpenImToken openImToken, AddDefaultFriendReq req) {
        return openImAdminRest.defaultUserAdd(openImToken, req);
    }

    /**
     * 删除注册时默认好友
     *
     * @param req
     * @return
     */
    public OpenImResult<String> defaultUserDel(OpenImToken openImToken, DelDefaultFriendReq req) {
        return openImAdminRest.defaultUserDel(openImToken, req);
    }

    /**
     * 默认好友列表
     *
     * @param req
     * @return
     */
    public OpenImResult<FindDefaultFriendResp> defaultUserFind(OpenImToken openImToken, FindDefaultFriendReq req) {
        return openImAdminRest.defaultUserFind(openImToken, req);
    }

    /**
     * 搜索注册时默认好友列表
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchDefaultFriendResp> defaultUserSearch(OpenImToken openImToken, SearchDefaultFriendReq req) {
        return openImAdminRest.defaultUserSearch(openImToken, req);
    }

    /**
     * newUserCount
     * routePath=/statistic/new_user_count
     *
     * @param req
     * @return
     */
    public OpenImResult<NewUserCountResp> newUserCount(OpenImToken openImToken, UserRegisterCountReq req) {
        return openImAdminRest.newUserCount(openImToken, req);
    }

    /**
     * loginUserCount
     * routePath=/statistic/login_user_count
     *
     * @param req
     * @return
     */
    public OpenImResult<UserLoginCountResp> loginUserCount(OpenImToken openImToken, UserLoginCountReq req) {
        return openImAdminRest.loginUserCount(openImToken, req);
    }

    /**
     * searchLogs
     * routePath=/logs/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchLogsResp> searchLogs(OpenImToken openImToken, SearchLogsReq req) {
        return openImAdminRest.searchLogs(openImToken, req);
    }
}
