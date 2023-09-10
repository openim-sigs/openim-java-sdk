package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.api.vo.GroupInfoForSet;

import javax.validation.constraints.NotNull;

@Data
public class SetGroupInfoReq {
    @NotNull
    private GroupInfoForSet groupInfoForSet;
}
