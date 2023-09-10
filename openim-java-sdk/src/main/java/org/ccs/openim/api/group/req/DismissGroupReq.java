package org.ccs.openim.api.group.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DismissGroupReq {
    @NotNull
    private String groupID;
    private boolean deleteMember;
}
