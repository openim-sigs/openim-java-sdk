package org.ccs.openim.api.msg.req;

import lombok.Data;

@Data
public class SetConversationHasReadSeqReq {
    private String conversationID;
    private Long hasReadSeq;
    private String userID;
}
