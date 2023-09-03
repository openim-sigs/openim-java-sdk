package org.ccs.openim.api.user.resp;

import lombok.Data;

import java.util.List;

@Data
public class AccountCheckResp {
    private List<AccountCheckRespSingleUserStatus> results;
}
