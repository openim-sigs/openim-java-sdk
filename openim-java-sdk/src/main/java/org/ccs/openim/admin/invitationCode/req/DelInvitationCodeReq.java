package org.ccs.openim.admin.invitationCode.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class DelInvitationCodeReq {
    @NotEmpty
    private List<String> codes;
}
