package org.ccs.openim.account.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


@Data
public class AdminLoginReq {
    @NotNull
    @Length(min = 3, max = 64)
    private String account;
    @NotNull
    @Length(min = 3, max = 64)
    private String password;
}