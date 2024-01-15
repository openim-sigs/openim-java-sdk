package org.ccs.openim.api.conversation.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import java.util.List;

@Data
public class GetSortedConversationListReq {
    private String userID;
    private List<String> conversationIDs;
    private RequestPagination pagination;
}
