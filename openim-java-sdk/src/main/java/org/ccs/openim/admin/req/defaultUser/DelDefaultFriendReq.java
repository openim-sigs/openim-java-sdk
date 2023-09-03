package org.ccs.openim.admin.req.defaultUser;

import lombok.Data;

import java.util.List;

@Data
public class DelDefaultFriendReq {
    private List<String> userIDs;
}
