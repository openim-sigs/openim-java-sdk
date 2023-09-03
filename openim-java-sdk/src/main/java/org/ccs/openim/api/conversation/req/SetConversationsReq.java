package org.ccs.openim.api.conversation.req;

import lombok.Data;

import java.util.List;

@Data
public class SetConversationsReq {
    private List<String> userIDs;
    private ConversationReq conversation;
}
