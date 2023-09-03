package org.ccs.openim.api.user.req;

import lombok.Data;

import java.util.List;

@Data
public class GetUsersOnlineStatusReq {
    private List<String> userIDs;
}
