package org.ccs.openim.account.req;

import lombok.Data;

import java.util.List;

@Data
public class DelAdminAccountReq {
    private List<String> userIDs;
}
