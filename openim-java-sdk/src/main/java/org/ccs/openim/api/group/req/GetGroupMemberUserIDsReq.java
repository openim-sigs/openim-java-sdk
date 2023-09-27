package org.ccs.openim.api.group.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class GetGroupMemberUserIDsReq {
    @NotNull
    private String groupID;
}
