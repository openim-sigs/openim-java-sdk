package org.ccs.openim.chat.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

@Data
public class SearchUserPublicInfoReq {
    private RequestPagination pagination;

    private String keyword;
    private Integer genders;
}
