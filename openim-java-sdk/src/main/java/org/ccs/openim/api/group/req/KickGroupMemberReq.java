package org.ccs.openim.api.group.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
public class KickGroupMemberReq {
    @NotNull
    private String groupID;
    @NotEmpty
    private List<String> kickedUserIDs;
    private String reason;
}
