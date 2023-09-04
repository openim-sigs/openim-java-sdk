package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.conversation.req.GetAllConversationsReq;
import org.ccs.openim.api.conversation.req.GetConversationReq;
import org.ccs.openim.api.conversation.req.GetConversationsReq;
import org.ccs.openim.api.conversation.req.SetConversationsReq;
import org.ccs.openim.api.conversation.resp.GetAllConversationsResp;
import org.ccs.openim.api.conversation.resp.GetConversationResp;
import org.ccs.openim.api.conversation.resp.GetConversationsResp;
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
public class OpenImApiConversationRest {
    public OpenImApiConversationRest() {
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
     * getAllConversations
     * routePath=/conversation/get_all_conversations
     *
     * @param req
     * @return
     */
    public OpenImResult<GetAllConversationsResp> getAllConversations(OpenImToken openImToken, GetAllConversationsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/conversation/get_all_conversations");


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetAllConversationsResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetAllConversationsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getAllConversations--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * getConversation
     * routePath=/conversation/get_conversation
     *
     * @param req
     * @return
     */
    public OpenImResult<GetConversationResp> getConversation(OpenImToken openImToken, GetConversationReq req) {
//        ValidateUtils.notNull(token, "token is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/conversation/get_conversation");


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetConversationResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetConversationResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getConversation--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * getConversations
     * routePath=/conversation/get_conversations
     *
     * @param req
     * @return
     */
    public OpenImResult<GetConversationsResp> getConversations(OpenImToken openImToken, GetConversationsReq req) {
//        ValidateUtils.notNull(token, "token is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/conversation/get_conversations");


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetConversationsResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetConversationsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getConversations--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * setConversations
     * routePath=/conversation/set_conversations
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setConversations(OpenImToken openImToken, SetConversationsReq req) {
//        ValidateUtils.notNull(token, "token is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/conversation/set_conversations");


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----setConversations--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
