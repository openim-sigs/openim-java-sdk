package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.conversation.req.*;
import org.ccs.openim.api.conversation.resp.GetAllConversationsResp;
import org.ccs.openim.api.conversation.resp.GetConversationOfflinePushUserIDsResp;
import org.ccs.openim.api.conversation.resp.GetConversationResp;
import org.ccs.openim.api.conversation.resp.GetConversationsResp;
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
public class OpenImApiConversationRest {
    public OpenImApiConversationRest() {
        this.init();
    }


    public static final ApiServerType SERVER_TYPE = ApiServerType.API;


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


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetAllConversationsResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetAllConversationsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getAllConversations--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
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


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetConversationResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetConversationResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getConversation--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
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


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetConversationsResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetConversationsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getConversations--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
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


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----setConversations--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


    /**
     * getConversationOfflinePushUserIDs
     * /conversation/get_conversation_offline_push_user_ids
     *
     * @param req
     * @return
     */
    public OpenImResult<GetConversationOfflinePushUserIDsResp> getConversationOfflinePushUserIDs(OpenImToken openImToken, GetConversationOfflinePushUserIDsReq req) {
//        ValidateUtils.notNull(token, "token is null");
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/conversation/get_conversation_offline_push_user_ids");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetConversationOfflinePushUserIDsResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetConversationOfflinePushUserIDsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getConversationOfflinePushUserIDs--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
