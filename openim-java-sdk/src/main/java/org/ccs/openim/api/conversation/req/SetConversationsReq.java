package org.ccs.openim.api.conversation.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetConversationsReq {
    @NotEmpty
    private List<String> userIDs;
    private ConversationReq conversation;
}
