package org.ccs.openim.api.group.req;

import lombok.Data;
import org.ccs.openim.api.vo.GroupInfo;

import java.util.List;

@Data
public class CreateGroupReq {
    private List<String> memberUserIDs;
    private GroupInfo groupInfo;
    private List<String> adminUserIDs;
    private String ownerUserID;

}
