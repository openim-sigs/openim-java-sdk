package org.ccs.openim.api.conversation.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllConversationsReq {
    @NotNull
    private String ownerUserID;
}
