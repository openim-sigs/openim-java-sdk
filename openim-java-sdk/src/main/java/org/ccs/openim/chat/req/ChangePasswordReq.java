package org.ccs.openim.chat.req;

import lombok.Data;

/**
 * @author chenjh
 */
@Data
public class ChangePasswordReq {
    private String userID;
    private String currentPassword;
    private String newPassword;
}
