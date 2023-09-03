package org.ccs.openim.api.group.req;

import lombok.Data;

@Data
public class DismissGroupReq {
    private String groupID;
    private boolean deleteMember;
}
