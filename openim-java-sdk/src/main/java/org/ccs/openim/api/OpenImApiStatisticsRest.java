package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.req.UserRegisterCountReq;
import org.ccs.openim.api.statistics.req.GetActiveGroupReq;
import org.ccs.openim.api.statistics.req.GetActiveUserReq;
import org.ccs.openim.api.statistics.req.GroupCreateCountReq;
import org.ccs.openim.api.statistics.resp.GetActiveGroupResp;
import org.ccs.openim.api.statistics.resp.GetActiveUserResp;
import org.ccs.openim.api.statistics.resp.GroupCreateCountResp;
import org.ccs.openim.api.statistics.resp.UserRegisterCountResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;

/**
 * Open-IM-Server服务接口
 *
 * @author chenjh
 */
@Slf4j
public class OpenImApiStatisticsRest {
    public OpenImApiStatisticsRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.API;


    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }


    /**
     * Get the total number of users and the user increment within a specified time period
     * routePath=/statistics/user/register
     *
     * @param req
     * @return
     */
    public OpenImResult<UserRegisterCountResp> userRegisterCount(OpenImToken openImToken, UserRegisterCountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/statistics/user/register");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<UserRegisterCountResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<UserRegisterCountResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----userRegisterCount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * getActiveUser
     * routePath=/statistics/user/active
     *
     * @param req
     * @return
     */
    public OpenImResult<GetActiveUserResp> getActiveUser(OpenImToken openImToken, GetActiveUserReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/statistics/user/active");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetActiveUserResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetActiveUserResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getActiveUser--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * groupCreateCount
     * routePath=/statistics/group/create
     *
     * @param req
     * @return
     */
    public OpenImResult<GroupCreateCountResp> groupCreateCount(OpenImToken openImToken, GroupCreateCountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/statistics/group/create");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GroupCreateCountResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GroupCreateCountResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----groupCreateCount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * getActiveGroup
     * routePath=/statistics/group/active
     *
     * @param req
     * @return
     */
    public OpenImResult<GetActiveGroupResp> getActiveGroup(OpenImToken openImToken, GetActiveGroupReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/statistics/group/active");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetActiveGroupResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetActiveGroupResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getActiveGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
