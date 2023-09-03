package org.ccs.openim.api.msg.req;

import lombok.Data;
import org.ccs.openim.api.msg.vo.SendMsg;

@Data
public class SendMsgReq extends SendMsg {
    private String recvID;
}
