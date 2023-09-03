package org.ccs.openim.chat.req;

import lombok.Data;

@Data
public class OpenIMCallbackReq {
    private String command;
    private String body;
}
