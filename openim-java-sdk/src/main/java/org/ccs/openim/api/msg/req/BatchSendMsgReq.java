package org.ccs.openim.api.msg.req;

import lombok.Data;
import org.ccs.openim.api.msg.vo.SendMsg;

import java.util.List;

@Data
public class BatchSendMsgReq extends SendMsg {
    private Boolean isSendAll;
    private List<String> recvIDs;
}
