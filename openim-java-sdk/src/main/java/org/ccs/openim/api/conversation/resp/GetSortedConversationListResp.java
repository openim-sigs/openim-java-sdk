package org.ccs.openim.api.conversation.resp;

import lombok.Data;
import org.ccs.openim.api.vo.ConversationElem;

import java.util.List;

@Data
public class GetSortedConversationListResp {
    private List<ConversationElem> conversationElems;
    private Long unreadTotal;
    private Long conversationTotal;
}
