package org.ccs.openim.admin.defaultUser.req;

import lombok.Data;

import java.util.List;

@Data
public class AddDefaultFriendReq {
    private List<String> userIDs;
}
