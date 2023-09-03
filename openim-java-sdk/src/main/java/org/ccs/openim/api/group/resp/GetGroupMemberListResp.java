package org.ccs.openim.api.group.resp;

import lombok.Data;
import org.ccs.openim.api.vo.GroupMemberFullInfo;

import java.util.List;

@Data
public class GetGroupMemberListResp {
    private Integer total;
    private List<GroupMemberFullInfo> members;
}
