package org.ccs.openim.admin.resp;

import lombok.Data;

import java.util.Map;

@Data
public class UserLoginCountResp {
    private Long loginCount;
    private Long unloginCount;
    private Map<String, Long> Count;
}
