package org.ccs.openim.api.conversation.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetConversationReq {
    private String conversationID;
    @NotNull
    private String ownerUserID;
}
