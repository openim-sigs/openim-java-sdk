package org.ccs.openim.api.msg.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RevokeMsgReq {
    @NotNull
    private String conversationID;
    private Long seq;

    private String userID;
}
