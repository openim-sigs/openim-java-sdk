package org.ccs.openim.api.user.resp;

import lombok.Data;
import org.ccs.openim.api.vo.OnlineStatus;

import java.util.List;

@Data
public class SubscribeOrCancelUsersStatusResp {
    private List<OnlineStatus> statusList;
}
