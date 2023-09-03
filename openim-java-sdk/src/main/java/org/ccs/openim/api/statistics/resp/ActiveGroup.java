package org.ccs.openim.api.statistics.resp;

import lombok.Data;
import org.ccs.openim.api.vo.GroupInfo;

@Data
public class ActiveGroup {
    private GroupInfo groupInfo;
    private Long count;
}
