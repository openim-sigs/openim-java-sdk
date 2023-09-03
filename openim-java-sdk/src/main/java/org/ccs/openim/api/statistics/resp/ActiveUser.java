package org.ccs.openim.api.statistics.resp;

import lombok.Data;
import org.ccs.openim.api.vo.UserInfo;

@Data
public class ActiveUser {
    private UserInfo user;
    private Long count;
}
