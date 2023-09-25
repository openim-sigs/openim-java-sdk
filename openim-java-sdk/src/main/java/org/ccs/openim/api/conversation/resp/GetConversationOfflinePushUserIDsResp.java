package org.ccs.openim.api.conversation.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetConversationOfflinePushUserIDsResp {
    private List<String> userIDs;
}
