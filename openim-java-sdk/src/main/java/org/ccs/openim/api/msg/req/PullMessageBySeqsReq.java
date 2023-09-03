package org.ccs.openim.api.msg.req;

import lombok.Data;

import java.util.List;

@Data
public class PullMessageBySeqsReq {
    private String userID;
    private List<SeqRange> seqRanges;
    private Integer order;
}
