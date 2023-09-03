package org.ccs.openim.api.user.req;

import lombok.Data;

import java.util.List;

@Data
public class GetUserStatusReq {
    private String userID;
    private List<String> userIDs;
}
