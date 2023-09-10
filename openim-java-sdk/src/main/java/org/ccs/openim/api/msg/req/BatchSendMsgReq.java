package org.ccs.openim.api.msg.req;

import lombok.Data;
import org.ccs.openim.api.msg.vo.SendMsg;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class BatchSendMsgReq extends SendMsg {
    private Boolean isSendAll;
    @NotEmpty
    private List<String> recvIDs;
}
