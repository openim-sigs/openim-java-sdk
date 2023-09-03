package org.ccs.openim.api.conversation.req;

import lombok.Data;

import java.util.List;

@Data
public class GetConversationsReq {
    private String ownerUserID;
    private List<String> conversationIDs;
}
