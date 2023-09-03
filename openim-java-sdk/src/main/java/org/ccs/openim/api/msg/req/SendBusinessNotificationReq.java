package org.ccs.openim.api.msg.req;

import lombok.Data;
import org.ccs.openim.api.msg.vo.SendMsg;

@Data
public class SendBusinessNotificationReq extends SendMsg {
    private String key;
    private String data;
    private String sendUserID;
    private String recvUserID;
}
