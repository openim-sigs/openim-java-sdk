package org.ccs.openim.api.msg.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetConversationsHasReadAndMaxSeqReq {
    @NotNull
    private String userID;
    @NotEmpty
    private List<String> conversationIDs;
}
