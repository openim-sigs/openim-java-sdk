package org.ccs.openim.api.group.resp;

import lombok.Data;
import org.ccs.openim.api.vo.GroupInfo;

import java.util.List;

@Data
public class GetGroupsInfoResp {
    private List<GroupInfo> groupInfos;
}
