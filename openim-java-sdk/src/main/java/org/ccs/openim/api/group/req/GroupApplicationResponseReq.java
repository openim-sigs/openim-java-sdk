package org.ccs.openim.api.group.req;

import lombok.Data;

@Data
public class GroupApplicationResponseReq {
    private String groupID;
    private String fromUserID;
    private String handledMsg;
    private Integer handleResult;
}
