package org.ccs.openim.api.user.req;

import lombok.Data;

import java.util.List;

@Data
public class SubscribeOrCancelUsersStatusReq {
    private String userID;
    private List<String> userIDs;
    private Integer genre;
}
