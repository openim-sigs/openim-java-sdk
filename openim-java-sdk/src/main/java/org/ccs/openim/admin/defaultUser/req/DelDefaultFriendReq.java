package org.ccs.openim.admin.defaultUser.req;

import lombok.Data;

import java.util.List;

@Data
public class DelDefaultFriendReq {
    private List<String> userIDs;
}
