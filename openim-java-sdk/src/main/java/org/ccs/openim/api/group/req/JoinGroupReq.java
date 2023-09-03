package org.ccs.openim.api.group.req;

import lombok.Data;

@Data
public class JoinGroupReq {
    private String groupID;
    private String reqMessage;
    private Integer joinSource;
    private String inviterUserID;
}
