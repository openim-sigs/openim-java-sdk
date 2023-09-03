package org.ccs.openim.api.user.resp;

import lombok.Data;
import org.ccs.openim.api.vo.OnlineStatus;

import java.util.List;

/**
 * @author chenjh
 */
@Data
public class GetUserStatusResp {
    private List<OnlineStatus> statusList;
}
