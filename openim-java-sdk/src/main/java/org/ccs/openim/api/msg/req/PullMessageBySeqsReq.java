package org.ccs.openim.api.msg.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PullMessageBySeqsReq {
    @NotNull
    private String userID;
    @NotEmpty
    private List<SeqRange> seqRanges;
    private Integer order;
}
