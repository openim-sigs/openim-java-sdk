package org.ccs.openim.api.user.resp;

import lombok.Data;
import org.ccs.openim.api.vo.UserInfo;

import java.util.List;

/**
 * @author chenjh
 */
@Data
public class GetAllUserIDResp {
    private Integer total;
    private List<UserInfo> usersInfo;
//    private List<String> userIDs;
}
