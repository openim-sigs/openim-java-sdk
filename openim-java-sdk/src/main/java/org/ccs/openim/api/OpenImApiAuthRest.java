package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.auth.req.ForceLogoutReq;
import org.ccs.openim.api.auth.req.ParseTokenReq;
import org.ccs.openim.api.auth.req.UserTokenReq;
import org.ccs.openim.api.auth.resp.ParseTokenResp;
import org.ccs.openim.api.auth.resp.UserTokenResp;
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
public class OpenImApiAuthRest {
    public OpenImApiAuthRest() {
        this.init();
    }


    public static final ApiServerType SERVER_TYPE = ApiServerType.API;

    private OpenimConfig openimConfig;

    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 获取用户token
     * routePath=/auth/user_token
     *
     * @param req
     * @return
     */
    public OpenImResult<UserTokenResp> userToken(OpenImToken openImToken, UserTokenReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/auth/user_token");

        if (CharSequenceUtil.isBlank(req.getSecret())) {
            req.setSecret(openimConfig.getSecret());
        }
        if (req.getPlatformID() == null) {
            req.setPlatformID(openimConfig.getPlatformId());
        }
        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<UserTokenResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<UserTokenResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----userToken--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 解析token
     * routePath=/auth/parse_token
     *
     * @param req
     * @return
     */
    public OpenImResult<ParseTokenResp> parseToken(OpenImToken openImToken, ParseTokenReq req) {
//        ValidateUtils.notNull(token, "token is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/auth/parse_token");




        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<ParseTokenResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<ParseTokenResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----parseToken--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 强制退出登录
     * routePath=/auth/force_logout
     *
     * @param req
     * @return
     */
    public OpenImResult<String> forceLogout(OpenImToken openImToken, ForceLogoutReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/auth/force_logout");


        if (req.getPlatformID() == null) {
            req.setPlatformID(openimConfig.getPlatformId());
        }
        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----forceLogout--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
