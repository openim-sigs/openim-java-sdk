package org.ccs.openim.api.msg.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
public class DeleteMsgPhysicalBySeqReq {
    @NotNull
    private String conversationID;
    @NotEmpty
    private List<Long> seqs;
}
