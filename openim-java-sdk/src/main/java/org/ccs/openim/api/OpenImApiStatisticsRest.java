package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
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
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;
import org.springframework.http.*;

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


    private HttpHeaders initPostHeader(OpenImToken openImToken) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("authKey", openimConfig.getAuthKey());
        requestHeaders.add(OpenimParams.OPERATIONID, openImToken.getOperationId());
        requestHeaders.add(OpenimParams.TOKEN, openImToken.getImToken());
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
    }

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


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<UserRegisterCountResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<UserRegisterCountResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----userRegisterCount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetActiveUserResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetActiveUserResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getActiveUser--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GroupCreateCountResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GroupCreateCountResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----groupCreateCount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetActiveGroupResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetActiveGroupResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getActiveGroup--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
