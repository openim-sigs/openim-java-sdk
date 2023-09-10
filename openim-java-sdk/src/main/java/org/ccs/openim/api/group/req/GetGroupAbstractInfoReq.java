package org.ccs.openim.api.group.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class GetGroupAbstractInfoReq {
    @NotEmpty
    private List<String> groupIDs;
}
