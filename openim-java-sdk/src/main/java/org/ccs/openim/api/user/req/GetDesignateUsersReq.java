package org.ccs.openim.api.user.req;

import lombok.Data;

import java.util.List;

@Data
public class GetDesignateUsersReq {
    private List<String> userIDs;
}
