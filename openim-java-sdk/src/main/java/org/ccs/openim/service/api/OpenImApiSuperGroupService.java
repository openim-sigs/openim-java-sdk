package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiSuperGroupRest;
import org.ccs.openim.api.group.req.GetGroupAbstractInfoReq;
import org.ccs.openim.api.group.resp.GetGroupAbstractInfoResp;
import org.ccs.openim.api.superGroup.req.GetJoinedSuperGroupListReq;
import org.ccs.openim.api.superGroup.resp.GetJoinedSuperGroupListResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImApiSuperGroupService {

    private OpenImApiSuperGroupRest openImApiSuperGroupRest = new OpenImApiSuperGroupRest();

    /**
     * 获取某个用户加入的超级群
     * routePath=/super_group/get_joined_group_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetJoinedSuperGroupListResp> getJoinedSuperGroupList(OpenImToken openImToken, GetJoinedSuperGroupListReq req) {
        ValidatorUtils.validate(req);
        return openImApiSuperGroupRest.getJoinedSuperGroupList(openImToken, req);
    }

    /**
     * 获取群信息hash值
     * routePath=/super_group/get_groups_info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupAbstractInfoResp> getGroupAbstractInfo(OpenImToken openImToken, GetGroupAbstractInfoReq req) {
        ValidatorUtils.validate(req);
        return openImApiSuperGroupRest.getGroupAbstractInfo(openImToken, req);
    }

}
