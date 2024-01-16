package org.ccs.openim.account.resp;

import lombok.Data;
import org.ccs.openim.admin.resp.GetAdminInfoResp;

import java.util.List;

@Data
public class SearchAdminAccountResp {
    private Integer total;
    private List<GetAdminInfoResp> adminAccounts;
}
