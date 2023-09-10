package org.ccs.openim.api.group.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetGroupMembersInfoReq {
    @NotNull
    private String groupID;
    @NotEmpty
    private List<String> userIDs;
}
