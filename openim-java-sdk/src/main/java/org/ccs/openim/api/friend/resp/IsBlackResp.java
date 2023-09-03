package org.ccs.openim.api.friend.resp;

import lombok.Data;

@Data
public class IsBlackResp {
    /**
     * 如果userID2在userID1的黑名单列表中 true
     */
    private boolean inUser1Blacks;
    /**
     * 如果userID1在userID2的黑名单列表中 true
     */
    private boolean inUser2Blacks;
}
