package org.ccs.openim.api.group.resp;

import lombok.Data;
import org.ccs.openim.api.vo.GroupRequest;

import java.util.List;

@Data
public class GetGroupApplicationListResp {
    private Integer total;
    private List<GroupRequest> groupRequests;
}
