package org.ccs.openim.api.msg.req;

import lombok.Data;

import java.util.List;

@Data
public class ClearConversationsMsgReq {
    private List<String> conversationIDs;
    private String userID;
    private DeleteSyncOpt deleteSyncOpt;
}
