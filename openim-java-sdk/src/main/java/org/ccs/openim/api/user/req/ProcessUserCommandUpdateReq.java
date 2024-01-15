package org.ccs.openim.api.user.req;

import lombok.Data;

@Data
public class ProcessUserCommandUpdateReq {
    private String userID;
    private Integer type;
    private String uuid;
    private String value;
    private String ex;
}
