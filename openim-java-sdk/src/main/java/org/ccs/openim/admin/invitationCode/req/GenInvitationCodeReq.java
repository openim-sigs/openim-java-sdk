package org.ccs.openim.admin.invitationCode.req;

import lombok.Data;

@Data
public class GenInvitationCodeReq {
    private Integer len;
    private Integer num;
    private String chars;
}
