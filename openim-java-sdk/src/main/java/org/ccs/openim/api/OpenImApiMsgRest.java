package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.msg.req.*;
import org.ccs.openim.api.msg.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

/**
 * Open-IM-Server服务接口
 * routePath=/msg/*
 *
 * @author chenjh
 */
@Service
@Slf4j
public class OpenImApiMsgRest {
    public OpenImApiMsgRest() {
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
     * 获取最小最大seq（包括用户的，以及指定群组的）
     * routePath=/msg/newest_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<GetMaxSeqResp> getSeq(OpenImToken openImToken, GetMaxSeqReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/newest_seq");


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetMaxSeqResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetMaxSeqResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getSeq--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 解搜索消息
     * routePath=/msg/search_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchMessageResp> searchMsg(OpenImToken openImToken, SearchMessageReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/search_msg");


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<SearchMessageResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<SearchMessageResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----SearchMessageResp--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 发送消息
     * routePath=/msg/send_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<SendMsgResp> sendMessage(OpenImToken openImToken, SendMsgReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/send_msg");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<SendMsgResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<SendMsgResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----sendMessage--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 发送消息
     * routePath=/msg/batch_send_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<BatchSendMsgResp> batchSendMsg(OpenImToken openImToken, BatchSendMsgReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/batch_send_msg");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<BatchSendMsgResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<BatchSendMsgResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----batchSendMsg--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 发送消息
     * routePath=/msg/send_business_notification
     *
     * @param req
     * @return
     */
    public OpenImResult<SendMsgResp> sendBusinessNotification(OpenImToken openImToken, SendBusinessNotificationReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/send_business_notification");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<SendMsgResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<SendMsgResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----sendBusinessNotification--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 拉取历史消息（包括用户的，以及指定群组的）
     * routePath=/msg/pull_msg_by_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<PullMessageBySeqsResp> pullMsgBySeqs(OpenImToken openImToken, PullMessageBySeqsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/pull_msg_by_seq");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<PullMessageBySeqsResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<PullMessageBySeqsResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----pullMsgBySeqs--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * revokeMsg
     * routePath=/msg/revoke_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<String> revokeMsg(OpenImToken openImToken, RevokeMsgReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/revoke_msg");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----revokeMsg--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * markMsgsAsRead
     * routePath=/msg/mark_msgs_as_read
     *
     * @param req
     * @return
     */
    public OpenImResult<String> markMsgsAsRead(OpenImToken openImToken, MarkMsgsAsReadReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/mark_msgs_as_read");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----markMsgsAsRead--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * markConversationAsRead
     * routePath=/msg/mark_conversation_as_read
     *
     * @param req
     * @return
     */
    public OpenImResult<String> markConversationAsRead(OpenImToken openImToken, MarkConversationAsReadReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/mark_conversation_as_read");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----markConversationAsRead--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * getConversationsHasReadAndMaxSeq
     * routePath=/msg/get_conversations_has_read_and_max_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<String> getConversationsHasReadAndMaxSeq(OpenImToken openImToken, GetConversationsHasReadAndMaxSeqReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/get_conversations_has_read_and_max_seq");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getConversationsHasReadAndMaxSeq--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * setConversationHasReadSeq
     * routePath=/msg/set_conversation_has_read_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setConversationHasReadSeq(OpenImToken openImToken, SetConversationHasReadSeqReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/set_conversation_has_read_seq");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----setConversationHasReadSeq--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 全量清空指定会话消息 重置min seq 比最大seq大1
     * routePath=/msg/clear_conversation_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<String> clearConversationsMsg(OpenImToken openImToken, ClearConversationsMsgReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/clear_conversation_msg");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----clearConversationsMsg--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 删除用户全部消息 重置min seq 比最大seq大1
     * routePath=/msg/user_clear_all_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<String> userClearAllMsg(OpenImToken openImToken, UserClearAllMsgReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/user_clear_all_msg");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----userClearAllMsg--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 用户标记删除部分消息by Seq
     * routePath=/msg/delete_msgs
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteMsgs(OpenImToken openImToken, DeleteMsgsReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/delete_msgs");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----deleteMsgs--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * seq物理删除消息
     * routePath=/msg/delete_msg_phsical_by_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteMsgPhysicalBySeq(OpenImToken openImToken, DeleteMsgPhysicalBySeqReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/delete_msg_phsical_by_seq");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----deleteMsgPhysicalBySeq--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 物理删除消息by 时间
     * routePath=/msg/delete_msg_physical
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteMsgPhysical(OpenImToken openImToken, DeleteMsgPhysicalReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/delete_msg_physical");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----deleteMsgPhysical--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 获取消息发送状态
     * routePath=/msg/check_msg_is_send_success
     *
     * @param req
     * @return
     */
    public OpenImResult<GetSendMsgStatusResp> checkMsgIsSendSuccess(OpenImToken openImToken, GetSendMsgStatusReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/check_msg_is_send_success");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetSendMsgStatusResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetSendMsgStatusResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----checkMsgIsSendSuccess--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }

    /**
     * 获取服务器时间
     * routePath=/msg/get_server_time
     *
     * @param req
     * @return
     */
    public OpenImResult<GetServerTimeResp> getServerTime(OpenImToken openImToken, GetServerTimeReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/msg/get_server_time");

        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetServerTimeResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetServerTimeResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getServerTime--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
