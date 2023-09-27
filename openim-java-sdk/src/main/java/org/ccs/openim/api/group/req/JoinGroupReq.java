package org.ccs.openim.api.group.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class JoinGroupReq {
    @NotNull
    private String groupID;
    private String reqMessage;
    private Integer joinSource;
    @NotNull
    private String inviterUserID;
}
