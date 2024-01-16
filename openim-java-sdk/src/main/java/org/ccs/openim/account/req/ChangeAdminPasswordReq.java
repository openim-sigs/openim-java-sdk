package org.ccs.openim.account.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ChangeAdminPasswordReq {
    @NotNull
    private String userID;
    @NotNull
    private String currentPassword;
    @NotNull
    private String newPassword;
}
