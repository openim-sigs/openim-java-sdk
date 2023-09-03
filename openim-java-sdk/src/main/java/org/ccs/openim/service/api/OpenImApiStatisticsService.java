package org.ccs.openim.service.api;

import org.ccs.openim.admin.req.UserRegisterCountReq;
import org.ccs.openim.api.OpenImApiStatisticsRest;
import org.ccs.openim.api.statistics.req.GetActiveUserReq;
import org.ccs.openim.api.statistics.req.GroupCreateCountReq;
import org.ccs.openim.api.statistics.resp.GetActiveUserResp;
import org.ccs.openim.api.statistics.resp.GroupCreateCountResp;
import org.ccs.openim.api.statistics.resp.UserRegisterCountResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImApiStatisticsService {
    @Resource
    private OpenImApiStatisticsRest openImApiStatisticsRest;

    /**
     * Get the total number of users and the user increment within a specified time period
     * routePath=/statistics/user/register
     *
     * @param req
     * @return
     */
    public OpenImResult<UserRegisterCountResp> userRegisterCount(OpenImToken openImToken, UserRegisterCountReq req) {
        return openImApiStatisticsRest.userRegisterCount(openImToken, req);
    }

    /**
     * getActiveUser
     * routePath=/statistics/user/active
     *
     * @param req
     * @return
     */
    public OpenImResult<GetActiveUserResp> getActiveUser(OpenImToken openImToken, GetActiveUserReq req) {
        return openImApiStatisticsRest.getActiveUser(openImToken, req);
    }

    /**
     * groupCreateCount
     * routePath=/statistics/group/create
     *
     * @param req
     * @return
     */
    public OpenImResult<GroupCreateCountResp> groupCreateCount(OpenImToken openImToken, GroupCreateCountReq req) {
        return openImApiStatisticsRest.groupCreateCount(openImToken, req);
    }
}
