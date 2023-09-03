package org.ccs.openim.api.user.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetUsersOnlineStatusResp_SuccessResult {
    private String userID;
    private String status;
    private List<GetUsersOnlineStatusResp_SuccessDetail> detailPlatformStatus;
}
