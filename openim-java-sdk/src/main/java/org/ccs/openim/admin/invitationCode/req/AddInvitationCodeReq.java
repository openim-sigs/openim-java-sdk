package org.ccs.openim.admin.invitationCode.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class AddInvitationCodeReq {
    @NotEmpty
    private List<String> codes;
}
