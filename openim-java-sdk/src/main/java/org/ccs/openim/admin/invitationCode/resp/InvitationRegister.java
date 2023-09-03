package org.ccs.openim.admin.invitationCode.resp;

import lombok.Data;
import org.ccs.openim.chat.vo.UserPublicInfo;

@Data
public class InvitationRegister {
    private String invitationCode;
    private Long createTime;
    private String usedUserID;
    private UserPublicInfo usedUser;
}
