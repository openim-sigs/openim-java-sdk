package org.ccs.openim.service.admin;

import org.ccs.openim.admin.OpenImAdminDefaultGroupRest;
import org.ccs.openim.admin.defaultGroup.req.AddDefaultGroupReq;
import org.ccs.openim.admin.defaultGroup.req.DelDefaultGroupReq;
import org.ccs.openim.admin.defaultGroup.req.FindDefaultGroupReq;
import org.ccs.openim.admin.defaultGroup.req.SearchDefaultGroupReq;
import org.ccs.openim.admin.defaultGroup.resp.FindDefaultGroupResp;
import org.ccs.openim.admin.defaultGroup.resp.SearchDefaultGroupResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImAdminDefaultGroupService {

    private OpenImAdminDefaultGroupRest openImAdminDefaultGroupRest = new OpenImAdminDefaultGroupRest();


    /**
     * 添加注册时默认群
     * routePath=/default/group/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addDefaultGroup(OpenImToken openImToken, AddDefaultGroupReq req) {
        ValidatorUtils.validate(req);
        return openImAdminDefaultGroupRest.addDefaultGroup(openImToken, req);
    }

    /**
     * 删除注册时默认群
     * routePath=/default/group/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delDefaultGroup(OpenImToken openImToken, DelDefaultGroupReq req) {
        ValidatorUtils.validate(req);
        return openImAdminDefaultGroupRest.delDefaultGroup(openImToken, req);
    }

    /**
     * 获取注册时默认群列表
     * routePath=/default/group/find
     *
     * @param req
     * @return
     */
    public OpenImResult<FindDefaultGroupResp> findDefaultGroup(OpenImToken openImToken, FindDefaultGroupReq req) {
        ValidatorUtils.validate(req);
        return openImAdminDefaultGroupRest.findDefaultGroup(openImToken, req);
    }

    /**
     * 获取注册时默认群列表
     * routePath=/default/group/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchDefaultGroupResp> searchDefaultGroup(OpenImToken openImToken, SearchDefaultGroupReq req) {
        ValidatorUtils.validate(req);
        return openImAdminDefaultGroupRest.searchDefaultGroup(openImToken, req);
    }

}
