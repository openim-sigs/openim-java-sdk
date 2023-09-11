package org.ccs.openim.admin;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.forbidden.req.*;
import org.ccs.openim.admin.forbidden.resp.SearchIPForbiddenResp;
import org.ccs.openim.admin.forbidden.resp.SearchUserIPLimitLoginResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
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
public class OpenImAdminForbiddenRest {
    public OpenImAdminForbiddenRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.ADMIN;
    

    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 禁止用户在某些ip注册 增加
     * addIPForbidden
     * routePath=/forbidden/ip/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addIPForbidden(OpenImToken openImToken, AddIPForbiddenReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/forbidden/ip/add");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addIPForbidden--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
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
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/forbidden/ip/del");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----delIPForbidden--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
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
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/forbidden/ip/search");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<SearchIPForbiddenResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchIPForbiddenResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchIPForbidden--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
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
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/forbidden/user/add");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addUserIPLimitLogin--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 用户登录ip限制查询
     * delUserIPLimitLogin
     * routePath=/forbidden/user/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delUserIPLimitLogin(OpenImToken openImToken, DelUserIPLimitLoginReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/forbidden/user/del");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----delUserIPLimitLogin--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 用户登录ip限制查询
     * searchUserIPLimitLogin
     * routePath=/forbidden/user/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchUserIPLimitLoginResp> searchUserIPLimitLogin(OpenImToken openImToken, SearchUserIPLimitLoginReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/forbidden/user/search");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<SearchUserIPLimitLoginResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchUserIPLimitLoginResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchUserIPLimitLogin--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

}
