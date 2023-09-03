package org.ccs.openim.admin.invitationCode.resp;

import lombok.Data;

import java.util.List;

@Data
public class SearchInvitationCodeResp {
    private Integer total;
    private List<InvitationRegister> list;
}
