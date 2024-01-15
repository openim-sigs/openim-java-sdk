package org.ccs.openim.api.user.req;

import lombok.Data;

@Data
public class ProcessUserCommandDeleteReq {
    private String userID;
    private Integer type;
    private String uuid;
}
