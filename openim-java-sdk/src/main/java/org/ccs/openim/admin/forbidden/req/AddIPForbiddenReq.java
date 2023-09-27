package org.ccs.openim.admin.forbidden.req;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class AddIPForbiddenReq {
    @NotEmpty
    private List<IPForbiddenAdd> forbiddens;
}
