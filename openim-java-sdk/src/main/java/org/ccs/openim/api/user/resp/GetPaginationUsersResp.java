package org.ccs.openim.api.user.resp;

import lombok.Data;
import org.ccs.openim.api.vo.UserInfo;

import java.util.List;

@Data
public class GetPaginationUsersResp {
    private List<UserInfo> users;
    private Integer total;
}
