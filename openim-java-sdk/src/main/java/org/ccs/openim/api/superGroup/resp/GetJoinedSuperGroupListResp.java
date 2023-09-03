package org.ccs.openim.api.superGroup.resp;

import lombok.Data;
import org.ccs.openim.api.vo.GroupInfo;

import java.util.List;

@Data
public class GetJoinedSuperGroupListResp {
    private List<GroupInfo> groups;
}
