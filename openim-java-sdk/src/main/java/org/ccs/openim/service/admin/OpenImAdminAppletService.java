package org.ccs.openim.service.admin;

import org.ccs.openim.admin.OpenImAdminAppletRest;
import org.ccs.openim.admin.applet.req.AddAppletReq;
import org.ccs.openim.admin.applet.req.DelAppletReq;
import org.ccs.openim.admin.applet.req.SearchAppletReq;
import org.ccs.openim.admin.applet.req.UpdateAppletReq;
import org.ccs.openim.admin.applet.resp.SearchAppletResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImAdminAppletService {
    @Resource
    private OpenImAdminAppletRest openImAdminAppletRest;


    /**
     * 添加小程序
     * routePath=/applet/add
     *
     * @param req AddAppletReq
     * @return
     */
    public OpenImResult<String> appletAdd(OpenImToken openImToken, AddAppletReq req) {
        return openImAdminAppletRest.appletAdd(openImToken, req);
    }

    /**
     * 添加小程序
     * routePath=/applet/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> appletDel(OpenImToken openImToken, DelAppletReq req) {
        return openImAdminAppletRest.appletDel(openImToken, req);
    }

    /**
     * 添加小程序
     * routePath=/applet/update
     *
     * @param req
     * @return
     */
    public OpenImResult<String> appletUpdate(OpenImToken openImToken, UpdateAppletReq req) {
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
        return openImAdminAppletRest.appletSearch(openImToken, req);
    }

}
