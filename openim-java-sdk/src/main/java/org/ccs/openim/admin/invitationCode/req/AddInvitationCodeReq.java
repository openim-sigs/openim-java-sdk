package org.ccs.openim.admin.invitationCode.req;

import lombok.Data;

import java.util.List;

@Data
public class AddInvitationCodeReq {
    private List<String> codes;
}
