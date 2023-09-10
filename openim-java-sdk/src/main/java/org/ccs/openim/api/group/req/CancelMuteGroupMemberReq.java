package org.ccs.openim.api.group.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CancelMuteGroupMemberReq {
    @NotNull
    private String groupID;
    @NotNull
    private String userID;
}
