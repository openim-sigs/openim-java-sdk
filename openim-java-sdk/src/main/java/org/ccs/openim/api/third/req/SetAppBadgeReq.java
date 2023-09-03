package org.ccs.openim.api.third.req;

import lombok.Data;

@Data
public class SetAppBadgeReq {
    private String userID;
    private Integer appUnreadCount;
}
