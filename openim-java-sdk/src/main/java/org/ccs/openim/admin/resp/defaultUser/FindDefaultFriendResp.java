package org.ccs.openim.admin.resp.defaultUser;

import lombok.Data;

import java.util.List;

@Data
public class FindDefaultFriendResp {
    private List<String> userIDs;
}
