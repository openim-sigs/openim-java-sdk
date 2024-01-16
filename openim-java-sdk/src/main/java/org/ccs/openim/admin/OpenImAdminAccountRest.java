package org.ccs.openim.admin;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.account.req.*;
import org.ccs.openim.admin.resp.AdminLoginResp;
import org.ccs.openim.admin.resp.GetAdminInfoResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.chat.user.req.UpdateUserInfoReq;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * openIm-chat.admin服务接口
 *
 * @author chenjh
 */
@Slf4j
public class OpenImAdminAccountRest {
    public OpenImAdminAccountRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.ADMIN;

    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 登入
     * routePath=/account/login
     *
     * @param adminLoginReq
     * @return
     */
    public OpenImResult<AdminLoginResp> adminLogin(AdminLoginReq adminLoginReq, String operationid) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/login");

        Map<String, String> headerMap = new HashMap<>(4);
        headerMap.put(OpenimParams.OPERATIONID, operationid);

        String body = JSONUtil.toJsonStr(adminLoginReq);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, headerMap);

        OpenImResult<AdminLoginResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<AdminLoginResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----adminLogin--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 修改密码
     * routePath=/account/change_password
     *
     * @param req
     * @return
     */
    public OpenImResult<String> changeAdminPassword(OpenImToken openImToken, ChangeAdminPasswordReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/change_password");

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----changeAdminPassword--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取管理员信息
     * <p>
     * routePath=/account/info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetAdminInfoResp> adminInfo(OpenImToken openImToken, GetAdminInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/info");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<GetAdminInfoResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetAdminInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----adminInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 修改信息
     * <p>
     * routePath=/account/update
     *
     * @param req
     * @return
     */
    public OpenImResult<String> adminUpdateInfo(OpenImToken openImToken, UpdateUserInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/update");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----adminUpdateInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * Add admin account
     * routePath=/account/add_admin
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addAdminAccount(OpenImToken openImToken, AddAdminAccountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/add_admin");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addAdminAccount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * Add admin account
     * routePath=/account/add_user
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addUserAccount(OpenImToken openImToken, AddUserAccountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/add_user");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addUserAccount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * Delete admin
     * routePath=/account/del_admin
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delAdminAccount(OpenImToken openImToken, DelAdminAccountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/del_admin");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----delAdminAccount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * Get admin list
     * routePath=/account/search
     *
     * @param req
     * @return
     */
    public OpenImResult<String> searchAdminAccount(OpenImToken openImToken, SearchAdminAccountReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/search");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchAdminAccount--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

}
