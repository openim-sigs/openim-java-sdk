package org.ccs.openim.admin.req;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;


@Data
public class AdminLoginReq {
    @NotNull
    @Length(min = 3, max = 64)
    private String account;
    @NotNull
    @Length(min = 3, max = 64)
    private String password;
}