package org.ccs.openim.api.group.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class CancelMuteGroupMemberReq {
    @NotNull
    private String groupID;
    @NotNull
    private String userID;
}
