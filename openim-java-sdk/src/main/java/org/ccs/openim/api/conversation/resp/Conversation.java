package org.ccs.openim.api.conversation.resp;

import lombok.Data;

@Data
public class Conversation {
    private String ownerUserID;
    private String conversationID;
    private Integer recvMsgOpt;
    private Integer conversationType;
    private String userID;
    private String groupID;
    private Boolean isPinned;
    private String attachedInfo;
    private Boolean isPrivateChat;
    private Integer groupAtType;
    private String ex;
    private Integer burnDuration;
    private Long minSeq;
    private Long maxSeq;
    private Long msgDestructTime;
    private Long latestMsgDestructTime;
    private Boolean isMsgDestruct;
}
