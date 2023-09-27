package org.ccs.openim.api.group.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class DismissGroupReq {
    @NotNull
    private String groupID;
    private boolean deleteMember;
}
