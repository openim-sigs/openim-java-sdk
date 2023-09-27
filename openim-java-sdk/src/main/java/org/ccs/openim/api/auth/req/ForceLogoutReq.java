package org.ccs.openim.api.auth.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForceLogoutReq {
    private Integer platformID;
    @NotNull
    private String userID;
}
