package org.ccs.openim.admin.forbidden.req;

import lombok.Data;

@Data
public class UserIPLimitLogin {
    private String userID;
    private String ip;
}
