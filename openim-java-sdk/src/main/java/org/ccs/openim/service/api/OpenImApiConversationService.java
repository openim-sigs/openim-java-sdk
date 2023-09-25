package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiConversationRest;
import org.ccs.openim.api.conversation.req.*;
import org.ccs.openim.api.conversation.resp.GetAllConversationsResp;
import org.ccs.openim.api.conversation.resp.GetConversationOfflinePushUserIDsResp;
import org.ccs.openim.api.conversation.resp.GetConversationResp;
import org.ccs.openim.api.conversation.resp.GetConversationsResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImApiConversationService {

    private OpenImApiConversationRest openImApiConversationRest = new OpenImApiConversationRest();

    /**
     * getAllConversations
     * routePath=/conversation/get_all_conversations
     *
     * @param req
     * @return
     */
    public OpenImResult<GetAllConversationsResp> getAllConversations(OpenImToken openImToken, GetAllConversationsReq req) {
        ValidatorUtils.validate(req);
        return openImApiConversationRest.getAllConversations(openImToken, req);
    }

    /**
     * getConversation
     * routePath=/conversation/get_conversation
     *
     * @param req
     * @return
     */
    public OpenImResult<GetConversationResp> getConversation(OpenImToken openImToken, GetConversationReq req) {
        ValidatorUtils.validate(req);
        return openImApiConversationRest.getConversation(openImToken, req);
    }

    /**
     * getConversations
     * routePath=/conversation/get_conversations
     *
     * @param req
     * @return
     */
    public OpenImResult<GetConversationsResp> getConversations(OpenImToken openImToken, GetConversationsReq req) {
        ValidatorUtils.validate(req);
        return openImApiConversationRest.getConversations(openImToken, req);
    }

    /**
     * setConversations
     * routePath=/conversation/set_conversations
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setConversations(OpenImToken openImToken, SetConversationsReq req) {
        ValidatorUtils.validate(req);
        return openImApiConversationRest.setConversations(openImToken, req);
    }

    /**
     * getConversationOfflinePushUserIDs
     * /conversation/get_conversation_offline_push_user_ids
     *
     * @param req
     * @return
     */
    public OpenImResult<GetConversationOfflinePushUserIDsResp> getConversationOfflinePushUserIDs(OpenImToken openImToken, GetConversationOfflinePushUserIDsReq req){
        return openImApiConversationRest.getConversationOfflinePushUserIDs(openImToken, req);
    }


}
