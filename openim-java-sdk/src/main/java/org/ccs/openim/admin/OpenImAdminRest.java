package org.ccs.openim.admin;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.req.DeleteLogsReq;
import org.ccs.openim.admin.req.SearchLogsReq;
import org.ccs.openim.admin.req.UserLoginCountReq;
import org.ccs.openim.admin.req.UserRegisterCountReq;
import org.ccs.openim.admin.resp.NewUserCountResp;
import org.ccs.openim.admin.resp.SearchLogsResp;
import org.ccs.openim.admin.resp.UserLoginCountResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.chat.account.req.ChangePasswordReq;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;

/**
 * openIm-chat.admin服务接口
 *
 * @author chenjh
 */
@Slf4j
public class OpenImAdminRest {
    public OpenImAdminRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.ADMIN;
    
    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 修改密码
     *
     * @param req
     * @return
     */
    public OpenImResult<String> resetUserPassword(OpenImToken openImToken, ChangePasswordReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/user/password/reset");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----resetUserPassword--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * newUserCount
     *
     * @param req
     * @return
     */
    public OpenImResult<NewUserCountResp> newUserCount(OpenImToken openImToken, UserRegisterCountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/statistic/new_user_count");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<NewUserCountResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<NewUserCountResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----newUserCount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * loginUserCount
     *
     * @param req
     * @return
     */
    public OpenImResult<UserLoginCountResp> loginUserCount(OpenImToken openImToken, UserLoginCountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/statistic/login_user_count");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<UserLoginCountResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<UserLoginCountResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----loginUserCount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * searchLogs
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchLogsResp> searchLogs(OpenImToken openImToken, SearchLogsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/logs/search");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<SearchLogsResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchLogsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----newUserCount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * deleteLogs
     * routePath=/logs/delete
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteLogs(OpenImToken openImToken, DeleteLogsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/logs/delete");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----deleteLogs--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

}
