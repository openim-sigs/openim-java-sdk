package org.ccs.openim.api.conversation.req;

import lombok.Data;

import java.util.List;

@Data
public class GetConversationOfflinePushUserIDsReq {
    private String conversationID;
    private List<String> userIDs;
}
