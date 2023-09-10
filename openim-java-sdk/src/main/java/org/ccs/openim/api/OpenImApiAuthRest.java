package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.ccs.openim.api.auth.req.ForceLogoutReq;
import org.ccs.openim.api.auth.req.ParseTokenReq;
import org.ccs.openim.api.auth.req.UserTokenReq;
import org.ccs.openim.api.auth.resp.ParseTokenResp;
import org.ccs.openim.api.auth.resp.UserTokenResp;
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
public class OpenImApiAuthRest {
    public OpenImApiAuthRest() {
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        if (StringUtils.isBlank(req.getSecret())) {
            req.setSecret(openimConfig.getSecret());
        }
        if (req.getPlatformID() == null) {
            req.setPlatformID(openimConfig.getPlatformId());
        }
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<UserTokenResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<UserTokenResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----userToken--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<ParseTokenResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<ParseTokenResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----parseToken--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        if (req.getPlatformID() == null) {
            req.setPlatformID(openimConfig.getPlatformId());
        }
        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----forceLogout--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
