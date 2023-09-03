package org.ccs.openim.api.msg.req;

import lombok.Data;

import java.util.List;

@Data
public class GetConversationsHasReadAndMaxSeqReq {
    private String userID;
    private List<String> conversationIDs;
}
