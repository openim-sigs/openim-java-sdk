package org.ccs.openim.api.group.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetGroupsInfoReq {
    @NotEmpty
    private List<String> groupIDs;
}
