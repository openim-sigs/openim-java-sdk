package org.ccs.openim.chat.user.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class SearchUserFullInfoReq {

    private String keyword;
    private Integer genders;
    private Integer normal;
    @NotNull
    private RequestPagination pagination;
}
