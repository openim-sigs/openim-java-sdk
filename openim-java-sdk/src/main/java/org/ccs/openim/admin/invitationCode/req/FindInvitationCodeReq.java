package org.ccs.openim.admin.invitationCode.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class FindInvitationCodeReq {
    @NotEmpty
    private List<String> codes;
}
