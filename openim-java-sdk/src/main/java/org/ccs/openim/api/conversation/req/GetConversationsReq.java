package org.ccs.openim.api.conversation.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetConversationsReq {
    @NotNull
    private String ownerUserID;
    @NotEmpty
    private List<String> conversationIDs;
}
