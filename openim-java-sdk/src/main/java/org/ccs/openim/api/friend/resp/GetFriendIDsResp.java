package org.ccs.openim.api.friend.resp;

import lombok.Data;

import java.util.List;

@Data
public class GetFriendIDsResp {
    private List<String> friendIDs;
}
