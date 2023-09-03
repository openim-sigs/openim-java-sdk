package org.ccs.openim.api.msg.req;

import lombok.Data;

import java.util.List;

@Data
public class DeleteMsgPhysicalReq {
    private List<String> conversationIDs;
    private Long timestamp;
}
