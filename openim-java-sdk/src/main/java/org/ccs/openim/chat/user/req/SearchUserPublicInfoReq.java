package org.ccs.openim.chat.user.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class SearchUserPublicInfoReq {

    private String keyword;
    private Integer genders;
    @NotNull
    private RequestPagination pagination;
}
