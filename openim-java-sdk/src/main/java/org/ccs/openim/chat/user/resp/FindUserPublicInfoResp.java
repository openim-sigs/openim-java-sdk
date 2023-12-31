package org.ccs.openim.chat.user.resp;

import lombok.Data;
import org.ccs.openim.chat.vo.UserPublicInfo;

import java.util.List;

@Data
public class FindUserPublicInfoResp {
    private List<UserPublicInfo> users;
}
