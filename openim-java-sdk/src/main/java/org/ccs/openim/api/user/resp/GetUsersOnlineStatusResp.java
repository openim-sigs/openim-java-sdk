package org.ccs.openim.api.user.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetUsersOnlineStatusResp {
    private List<GetUsersOnlineStatusResp_SuccessResult> successResult;
    private List<GetUsersOnlineStatusResp_SuccessResult> failedResult;
}
