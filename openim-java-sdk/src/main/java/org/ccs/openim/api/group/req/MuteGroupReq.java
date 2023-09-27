package org.ccs.openim.api.group.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class MuteGroupReq {
    @NotNull
    private String groupID;
}
