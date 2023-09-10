package org.ccs.openim.api.msg.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class DeleteMsgPhysicalReq {
    @NotEmpty
    private List<String> conversationIDs;
    private Long timestamp;
}
