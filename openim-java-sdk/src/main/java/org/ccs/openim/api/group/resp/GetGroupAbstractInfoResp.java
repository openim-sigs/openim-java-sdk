package org.ccs.openim.api.group.resp;

import lombok.Data;
import org.ccs.openim.api.vo.GroupAbstractInfo;

import java.util.List;

@Data
public class GetGroupAbstractInfoResp {
    private List<GroupAbstractInfo> groupAbstractInfos;
}
