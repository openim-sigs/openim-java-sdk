package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiConversationRest;
import org.ccs.openim.api.conversation.req.GetAllConversationsReq;
import org.ccs.openim.api.conversation.req.GetConversationReq;
import org.ccs.openim.api.conversation.req.GetConversationsReq;
import org.ccs.openim.api.conversation.req.SetConversationsReq;
import org.ccs.openim.api.conversation.resp.GetAllConversationsResp;
import org.ccs.openim.api.conversation.resp.GetConversationResp;
import org.ccs.openim.api.conversation.resp.GetConversationsResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;


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
        return openImApiConversationRest.setConversations(openImToken, req);
    }


}
