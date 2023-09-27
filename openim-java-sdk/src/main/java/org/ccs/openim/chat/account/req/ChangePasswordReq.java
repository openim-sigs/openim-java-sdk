package org.ccs.openim.chat.account.req;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

/**
 * @author chenjh
 */
@Data
public class ChangePasswordReq {
    @NotNull
    private String userID;
    @NotNull
    private String currentPassword;
    @NotNull
    private String newPassword;
}
