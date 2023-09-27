package org.ccs.openim.admin.forbidden.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IPForbiddenAdd {
    @NotNull
    private String ip;
    private Boolean limitRegister;
    private Boolean limitLogin;
}
