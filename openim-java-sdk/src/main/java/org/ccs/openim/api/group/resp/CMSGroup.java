package org.ccs.openim.api.group.resp;

import lombok.Data;
import org.ccs.openim.api.vo.GroupInfo;

@Data
public class CMSGroup {
    private GroupInfo groupInfo;
    private String groupOwnerUserName;
    private String groupOwnerUserID;
}
