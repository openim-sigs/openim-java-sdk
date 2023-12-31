package org.ccs.openim.service.admin;

import org.ccs.openim.admin.OpenImAdminForbiddenRest;
import org.ccs.openim.admin.forbidden.req.AddIPForbiddenReq;
import org.ccs.openim.admin.forbidden.req.AddUserIPLimitLoginReq;
import org.ccs.openim.admin.forbidden.req.DelIPForbiddenReq;
import org.ccs.openim.admin.forbidden.req.SearchIPForbiddenReq;
import org.ccs.openim.admin.forbidden.resp.SearchIPForbiddenResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImAdminForbiddenService {

    private OpenImAdminForbiddenRest openImAdminForbiddenRest = new OpenImAdminForbiddenRest();


    /**
     * 禁止用户在某些ip注册 增加
     * addIPForbidden
     * routePath=/forbidden/ip/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addIPForbidden(OpenImToken openImToken, AddIPForbiddenReq req) {
        ValidatorUtils.validate(req);
        return openImAdminForbiddenRest.addIPForbidden(openImToken, req);
    }

    /**
     * 禁止用户在某些ip注册 删除
     * delIPForbidden
     * routePath=/forbidden/ip/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delIPForbidden(OpenImToken openImToken, DelIPForbiddenReq req) {
        ValidatorUtils.validate(req);
        return openImAdminForbiddenRest.delIPForbidden(openImToken, req);
    }

    /**
     * 禁止用户在某些ip注册 查询
     * searchIPForbidden
     * routePath=/forbidden/ip/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchIPForbiddenResp> searchIPForbidden(OpenImToken openImToken, SearchIPForbiddenReq req) {
        ValidatorUtils.validate(req);
        return openImAdminForbiddenRest.searchIPForbidden(openImToken, req);
    }

    /**
     * 用户登录ip限制 增加
     * addUserIPLimitLogin
     * routePath=/forbidden/user/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addUserIPLimitLogin(OpenImToken openImToken, AddUserIPLimitLoginReq req) {
        ValidatorUtils.validate(req);
        return openImAdminForbiddenRest.addUserIPLimitLogin(openImToken, req);
    }

}
