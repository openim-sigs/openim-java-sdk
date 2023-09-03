package org.ccs.openim.api.msg.req;

import lombok.Data;

import java.util.List;

@Data
public class MarkConversationAsReadReq {
    private String conversationID;
    private List<Long> seqs;
    private Long hasReadSeq;
    private String userID;
}
