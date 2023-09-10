package org.ccs.openim.api.msg.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import javax.validation.constraints.NotNull;

@Data
public class SearchMessageReq {
    /**
     * 发送者ID
     */
    private String sendID;
    /**
     * 接收者ID
     */
    private String recvID;
    private Integer msgType;
    private String sendTime;
    private Integer sessionType;
    @NotNull
    private RequestPagination pagination;
}
