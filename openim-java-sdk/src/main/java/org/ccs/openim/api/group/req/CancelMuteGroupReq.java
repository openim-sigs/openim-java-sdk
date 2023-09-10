package org.ccs.openim.api.group.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CancelMuteGroupReq {
    @NotNull
    private String groupID;
}
