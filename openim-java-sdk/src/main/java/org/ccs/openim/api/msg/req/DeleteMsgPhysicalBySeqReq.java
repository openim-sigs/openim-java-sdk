package org.ccs.openim.api.msg.req;

import lombok.Data;

import java.util.List;

@Data
public class DeleteMsgPhysicalBySeqReq {
    private String conversationID;
    private List<Long> seqs;
}
