package org.ccs.openim.chat.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchUserFullInfoReq {
    private RequestPagination pagination;

    private String keyword;
    private Integer genders;
    private Integer normal;
}
