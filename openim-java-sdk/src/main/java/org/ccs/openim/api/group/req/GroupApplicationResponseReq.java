package org.ccs.openim.api.group.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class GroupApplicationResponseReq {
    @NotNull
    private String groupID;
    private String fromUserID;
    private String handledMsg;
    private Integer handleResult;
}
