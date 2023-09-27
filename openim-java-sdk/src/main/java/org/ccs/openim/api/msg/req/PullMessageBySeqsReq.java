package org.ccs.openim.api.msg.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
public class PullMessageBySeqsReq {
    @NotNull
    private String userID;
    @NotEmpty
    private List<SeqRange> seqRanges;
    private Integer order;
}
