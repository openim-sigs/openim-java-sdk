package org.ccs.openim.service.admin;

import org.ccs.openim.admin.OpenImAdminRest;
import org.ccs.openim.admin.req.*;
import org.ccs.openim.admin.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.chat.account.req.ChangePasswordReq;
import org.ccs.openim.chat.user.req.UpdateUserInfoReq;
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
     * @param adminLoginReq
     * @return
     */
    public OpenImResult<AdminLoginResp> adminLogin(AdminLoginReq adminLoginReq, String operationid) {
        return openImAdminRest.adminLogin(adminLoginReq, operationid);
    }

    /**
     * 获取管理员信息
     * routePath=/account/info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetAdminInfoResp> adminInfo(OpenImToken openImToken, GetAdminInfoReq req) {
        return openImAdminRest.adminInfo(openImToken, req);
    }

    /**
     * 修改信息
     * routePath=/account/update
     *
     * @param req
     * @return
     */
    public OpenImResult<String> adminUpdateInfo(OpenImToken openImToken, UpdateUserInfoReq req) {
        return openImAdminRest.adminUpdateInfo(openImToken, req);
    }

    /**
     * 修改密码
     *
     * @param req
     * @return
     */
    public OpenImResult<String> resetUserPassword(OpenImToken openImToken, ChangePasswordReq req){
        return openImAdminRest.resetUserPassword(openImToken, req);
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

    /**
     * deleteLogs
     * routePath=/logs/delete
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteLogs(OpenImToken openImToken, DeleteLogsReq req){
        return openImAdminRest.deleteLogs(openImToken, req);
    }
}
