package org.ccs.openim.api.conversation.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class ConversationReq {
    private String conversationID;
    private Integer conversationType;
    @NotNull
    private String userID;
    private String groupID;
    private Integer recvMsgOpt;
    private Boolean isPinned;
    private String attachedInfo;
    private Boolean isPrivateChat;
    private String ex;
    private Integer burnDuration;
    private Long minSeq;
    private Long maxSeq;
    private Integer groupAtType;
    private Long msgDestructTime;
    private Boolean isMsgDestruct;
}
