package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.api.vo.SetGroupMemberInfo;

import java.util.List;

@Data

public class SetGroupMemberInfoReq {
    private List<SetGroupMemberInfo> members;
}
