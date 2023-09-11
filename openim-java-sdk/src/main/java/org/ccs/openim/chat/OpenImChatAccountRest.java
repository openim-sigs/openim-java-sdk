package org.ccs.openim.chat;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.chat.account.req.*;
import org.ccs.openim.chat.account.resp.LoginResp;
import org.ccs.openim.chat.account.resp.UserRegisterResp;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * openIm-chat服务接口
 *
 * @author chenjh
 */
@Slf4j
public class OpenImChatAccountRest {
    public OpenImChatAccountRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.CHAT;
    
    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 发送验证码
     *
     * @param req
     * @return
     */
    public OpenImResult<String> codeSend(SendVerifyCodeReq req, String operationId) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/code/send");


        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put(OpenimParams.OPERATIONID, operationId);
        String body = JSONUtil.toJsonStr(req);

        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, httpHeaders);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----codeSend--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 校验验证码
     *
     * @param req
     * @return
     */
    public OpenImResult<String> codeVerify(VerifyCodeReq req, String operationId) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/code/verify");


        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put(OpenimParams.OPERATIONID, operationId);
        String body = JSONUtil.toJsonStr(req);

        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, httpHeaders);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----codeVerify--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * 登入
     *
     * @param loginReq
     * @return
     */
    public OpenImResult<LoginResp> login(LoginReq loginReq, String operationId) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/login");
        

        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put(OpenimParams.OPERATIONID, operationId);
        String body = JSONUtil.toJsonStr(loginReq);

        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, httpHeaders);

        OpenImResult<LoginResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<LoginResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----login--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 注册
     *
     * @param userReq
     * @return
     */
    public OpenImResult<UserRegisterResp> register(RegisterUserReq userReq) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/register");

        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put(OpenimParams.OPERATIONID, "");
        String body = JSONUtil.toJsonStr(userReq);

        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, httpHeaders);

        OpenImResult<UserRegisterResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<UserRegisterResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----register--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 忘记密码
     *
     * @param req
     * @return
     */
    public OpenImResult<String> passwordReset(ResetPasswordReq req) {
//        ValidateUtils.notNull(loginVo.getPhoneNumber(), "phoneNumber is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/password/reset");


        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put(OpenimParams.OPERATIONID, "");
        String body = JSONUtil.toJsonStr(req);
        
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, httpHeaders);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----register--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 修改密码
     *
     * @param req
     * @return
     */
    public OpenImResult<String> passwordChange(OpenImToken openImToken, ChangePasswordReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/account/password/change");
        

        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.chatHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----register--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
