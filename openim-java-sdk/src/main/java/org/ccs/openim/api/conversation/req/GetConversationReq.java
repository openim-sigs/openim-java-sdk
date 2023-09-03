package org.ccs.openim.api.conversation.req;

import lombok.Data;

@Data
public class GetConversationReq {
    private String conversationID;
    private String ownerUserID;
}
