package org.ccs.openim.chat;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.chat.req.FindAppletReq;
import org.ccs.openim.chat.req.GetClientConfigReq;
import org.ccs.openim.chat.req.OpenIMCallbackReq;
import org.ccs.openim.chat.resp.FindAppletResp;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;
import org.springframework.http.*;


/**
 * openIm-chat服务接口
 *
 * @author chenjh
 */

@Slf4j
public class OpenImChatOtherRest {
    public OpenImChatOtherRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.CHAT;


    private HttpHeaders initPostHeader(OpenImToken openImToken) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("authKey", openimConfig.getAuthKey());
        requestHeaders.add(OpenimParams.OPERATIONID, openImToken.getOperationId());
        requestHeaders.add(OpenimParams.TOKEN, openImToken.getChatToken());
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
    }

    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    public OpenImResult<FindAppletResp> appletFind(OpenImToken openImToken, FindAppletReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/applet/find");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<FindAppletResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<FindAppletResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----appletFind--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    public OpenImResult<GetClientConfigResp> getClientConfig(OpenImToken openImToken, GetClientConfigReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/client_config/get");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetClientConfigResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetClientConfigResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getClientConfig--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    public OpenImResult<String> callbackOpenIm(OpenImToken openImToken, OpenIMCallbackReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/callback/open_im");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----callbackOpenIm--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
