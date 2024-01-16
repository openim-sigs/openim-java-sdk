package org.ccs.openim.service.admin;

import org.ccs.openim.account.req.*;
import org.ccs.openim.admin.OpenImAdminAccountRest;
import org.ccs.openim.admin.resp.AdminLoginResp;
import org.ccs.openim.admin.resp.GetAdminInfoResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.chat.user.req.UpdateUserInfoReq;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImAdminAccountService {

    private OpenImAdminAccountRest openImAdminRest = new OpenImAdminAccountRest();

    /**
     * 登入
     * routePath=/account/login
     *
     * @param adminLoginReq
     * @return
     */
    public OpenImResult<AdminLoginResp> adminLogin(AdminLoginReq adminLoginReq, String operationid) {
        ValidatorUtils.validate(adminLoginReq);
        return openImAdminRest.adminLogin(adminLoginReq, operationid);
    }

    /**
     * 修改密码
     * routePath=/account/change_password
     *
     * @param req
     * @return
     */
    public OpenImResult<String> changeAdminPassword(OpenImToken openImToken, ChangeAdminPasswordReq req) {
        ValidatorUtils.validate(openImToken);
        return openImAdminRest.changeAdminPassword(openImToken, req);
    }

    /**
     * 获取管理员信息
     * routePath=/account/info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetAdminInfoResp> adminInfo(OpenImToken openImToken, GetAdminInfoReq req) {
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
        return openImAdminRest.adminUpdateInfo(openImToken, req);
    }

    /**
     * Add admin account
     * routePath=/account/add_admin
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addAdminAccount(OpenImToken openImToken, AddAdminAccountReq req) {
        ValidatorUtils.validate(req);
        return openImAdminRest.addAdminAccount(openImToken, req);
    }

    /**
     * Add admin account
     * routePath=/account/add_user
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addUserAccount(OpenImToken openImToken, AddUserAccountReq req) {
        ValidatorUtils.validate(req);
        return openImAdminRest.addUserAccount(openImToken, req);
    }

    /**
     * Delete admin
     * routePath=/account/del_admin
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delAdminAccount(OpenImToken openImToken, DelAdminAccountReq req) {
        ValidatorUtils.validate(req);
        return openImAdminRest.delAdminAccount(openImToken, req);
    }

    /**
     * Get admin list
     * routePath=/account/search
     *
     * @param req
     * @return
     */
    public OpenImResult<String> searchAdminAccount(OpenImToken openImToken, SearchAdminAccountReq req) {
        ValidatorUtils.validate(req);
        return openImAdminRest.searchAdminAccount(openImToken, req);
    }
}
