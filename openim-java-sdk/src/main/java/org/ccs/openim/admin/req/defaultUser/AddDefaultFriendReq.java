package org.ccs.openim.admin.req.defaultUser;

import lombok.Data;

import java.util.List;

@Data
public class AddDefaultFriendReq {
    private List<String> userIDs;
}
