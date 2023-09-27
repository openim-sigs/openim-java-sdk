package org.ccs.openim.chat.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class OpenIMCallbackReq {
    @NotNull
    private String command;
    private String body;
}
