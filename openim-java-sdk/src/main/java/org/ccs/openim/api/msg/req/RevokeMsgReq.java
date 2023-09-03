package org.ccs.openim.api.msg.req;

import lombok.Data;

@Data
public class RevokeMsgReq {
    private String conversationID;
    private Long seq;

    private String userID;
}
