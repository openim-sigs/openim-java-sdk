package org.ccs.openim.api.group.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MuteGroupReq {
    @NotNull
    private String groupID;
}
