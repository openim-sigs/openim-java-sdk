package org.ccs.openim.service.admin;

import org.ccs.openim.admin.OpenImAdminAppletRest;
import org.ccs.openim.admin.applet.req.AddAppletReq;
import org.ccs.openim.admin.applet.req.DelAppletReq;
import org.ccs.openim.admin.applet.req.SearchAppletReq;
import org.ccs.openim.admin.applet.req.UpdateAppletReq;
import org.ccs.openim.admin.applet.resp.SearchAppletResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImAdminAppletService {

    private OpenImAdminAppletRest openImAdminAppletRest = new OpenImAdminAppletRest();


    /**
     * 添加小程序
     * routePath=/applet/add
     *
     * @param req AddAppletReq
     * @return
     */
    public OpenImResult<String> appletAdd(OpenImToken openImToken, AddAppletReq req) {
        ValidatorUtils.validate(req);
        return openImAdminAppletRest.appletAdd(openImToken, req);
    }

    /**
     * 删除小程序
     * routePath=/applet/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> appletDel(OpenImToken openImToken, DelAppletReq req) {
        ValidatorUtils.validate(req);
        return openImAdminAppletRest.appletDel(openImToken, req);
    }

    /**
     * 修改小程序
     * routePath=/applet/update
     *
     * @param req
     * @return
     */
    public OpenImResult<String> appletUpdate(OpenImToken openImToken, UpdateAppletReq req) {
        ValidatorUtils.validate(req);
        return openImAdminAppletRest.appletUpdate(openImToken, req);
    }

    /**
     * 搜索小程序
     * routePath=/applet/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchAppletResp> appletSearch(OpenImToken openImToken, SearchAppletReq req) {
        ValidatorUtils.validate(req);
        return openImAdminAppletRest.appletSearch(openImToken, req);
    }

}
