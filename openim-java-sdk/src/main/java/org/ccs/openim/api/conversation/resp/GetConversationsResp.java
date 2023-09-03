package org.ccs.openim.api.conversation.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetConversationsResp {
    private List<Conversation> conversations;
}
