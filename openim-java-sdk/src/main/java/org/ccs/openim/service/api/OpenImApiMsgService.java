package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiMsgRest;
import org.ccs.openim.api.msg.req.*;
import org.ccs.openim.api.msg.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImApiMsgService {
    @Resource
    private OpenImApiMsgRest openImApiMsgRest;

    /**
     * 获取最小最大seq（包括用户的，以及指定群组的）
     * routePath=/msg/newest_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<GetMaxSeqResp> getSeq(OpenImToken openImToken, GetMaxSeqReq req) {
        return openImApiMsgRest.getSeq(openImToken, req);
    }

    /**
     * 解搜索消息
     * routePath=/msg/search_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchMessageResp> searchMsg(OpenImToken openImToken, SearchMessageReq req) {
        return openImApiMsgRest.searchMsg(openImToken, req);
    }

    /**
     * 发送消息
     * routePath=/msg/send_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<SendMsgResp> sendMessage(OpenImToken openImToken, SendMsgReq req) {
        return openImApiMsgRest.sendMessage(openImToken, req);
    }

    /**
     * 发送消息
     * routePath=/msg/batch_send_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<BatchSendMsgResp> batchSendMsg(OpenImToken openImToken, BatchSendMsgReq req) {
        return openImApiMsgRest.batchSendMsg(openImToken, req);
    }

    /**
     * 发送消息
     * routePath=/msg/send_business_notification
     *
     * @param req
     * @return
     */
    public OpenImResult<SendMsgResp> sendBusinessNotification(OpenImToken openImToken, SendBusinessNotificationReq req) {
        return openImApiMsgRest.sendBusinessNotification(openImToken, req);
    }

    /**
     * 拉取历史消息（包括用户的，以及指定群组的）
     * routePath=/msg/pull_msg_by_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<PullMessageBySeqsResp> pullMsgBySeqs(OpenImToken openImToken, PullMessageBySeqsReq req) {
        return openImApiMsgRest.pullMsgBySeqs(openImToken, req);
    }

    /**
     * revokeMsg
     * routePath=/msg/revoke_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<String> revokeMsg(OpenImToken openImToken, RevokeMsgReq req) {
        return openImApiMsgRest.revokeMsg(openImToken, req);
    }

    /**
     * markMsgsAsRead
     * routePath=/msg/mark_msgs_as_read
     *
     * @param req
     * @return
     */
    public OpenImResult<String> markMsgsAsRead(OpenImToken openImToken, MarkMsgsAsReadReq req) {
        return openImApiMsgRest.markMsgsAsRead(openImToken, req);
    }

    /**
     * markConversationAsRead
     * routePath=/msg/mark_conversation_as_read
     *
     * @param req
     * @return
     */
    public OpenImResult<String> markConversationAsRead(OpenImToken openImToken, MarkConversationAsReadReq req) {
        return openImApiMsgRest.markConversationAsRead(openImToken, req);
    }

    /**
     * getConversationsHasReadAndMaxSeq
     * routePath=/msg/get_conversations_has_read_and_max_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<String> getConversationsHasReadAndMaxSeq(OpenImToken openImToken, GetConversationsHasReadAndMaxSeqReq req) {
        return openImApiMsgRest.getConversationsHasReadAndMaxSeq(openImToken, req);
    }

    /**
     * setConversationHasReadSeq
     * routePath=/msg/set_conversation_has_read_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setConversationHasReadSeq(OpenImToken openImToken, SetConversationHasReadSeqReq req) {
        return openImApiMsgRest.setConversationHasReadSeq(openImToken, req);
    }

    /**
     * 全量清空指定会话消息 重置min seq 比最大seq大1
     * routePath=/msg/clear_conversation_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<String> clearConversationsMsg(OpenImToken openImToken, ClearConversationsMsgReq req) {
        return openImApiMsgRest.clearConversationsMsg(openImToken, req);
    }

    /**
     * 删除用户全部消息 重置min seq 比最大seq大1
     * routePath=/msg/user_clear_all_msg
     *
     * @param req
     * @return
     */
    public OpenImResult<String> userClearAllMsg(OpenImToken openImToken, UserClearAllMsgReq req) {
        return openImApiMsgRest.userClearAllMsg(openImToken, req);
    }

    /**
     * 用户标记删除部分消息by Seq
     * routePath=/msg/delete_msgs
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteMsgs(OpenImToken openImToken, DeleteMsgsReq req) {
        return openImApiMsgRest.deleteMsgs(openImToken, req);
    }

    /**
     * seq物理删除消息
     * routePath=/msg/delete_msg_phsical_by_seq
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteMsgPhysicalBySeq(OpenImToken openImToken, DeleteMsgPhysicalBySeqReq req) {
        return openImApiMsgRest.deleteMsgPhysicalBySeq(openImToken, req);
    }

    /**
     * 物理删除消息by 时间
     * routePath=/msg/delete_msg_physical
     *
     * @param req
     * @return
     */
    public OpenImResult<String> deleteMsgPhysical(OpenImToken openImToken, DeleteMsgPhysicalReq req) {
        return openImApiMsgRest.deleteMsgPhysical(openImToken, req);
    }

    /**
     * 获取消息发送状态
     * routePath=/msg/check_msg_is_send_success
     *
     * @param req
     * @return
     */
    public OpenImResult<GetSendMsgStatusResp> checkMsgIsSendSuccess(OpenImToken openImToken, GetSendMsgStatusReq req) {
        return openImApiMsgRest.checkMsgIsSendSuccess(openImToken, req);
    }

    /**
     * 获取服务器时间
     * routePath=/msg/get_server_time
     *
     * @param req
     * @return
     */
    public OpenImResult<GetServerTimeResp> getServerTime(OpenImToken openImToken, GetServerTimeReq req) {
        return openImApiMsgRest.getServerTime(openImToken, req);
    }
}
