package org.ccs.openim.api.user.resp;

import lombok.Data;

@Data
public class GetUsersOnlineStatusResp_SuccessDetail {
    private String platform;
    private String status;
    private String connID;
    private String token;
    private boolean isBackground;
}
