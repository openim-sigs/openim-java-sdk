package org.ccs.openim.api.user.req;

import lombok.Data;

import java.util.List;

@Data
public class AccountCheckReq {
    private List<String> checkUserIDs;
}
