package org.ccs.openim.api.msg.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MarkConversationAsReadReq {
    @NotNull
    private String conversationID;
    @NotEmpty
    private List<Long> seqs;
    private Long hasReadSeq;
    private String userID;
}
