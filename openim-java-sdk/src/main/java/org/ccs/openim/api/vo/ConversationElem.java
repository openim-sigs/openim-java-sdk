package org.ccs.openim.api.vo;

import lombok.Data;

import java.util.List;

@Data
public class ConversationElem {
    private String conversationID;
    private Integer recvMsgOpt;
    private Long unreadCount;
    private Boolean IsPinned;
    private MsgInfo msgInfo;
}
