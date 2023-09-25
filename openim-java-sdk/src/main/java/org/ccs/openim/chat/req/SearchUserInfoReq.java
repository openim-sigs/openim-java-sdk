package org.ccs.openim.chat.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import java.util.List;

@Data
public class SearchUserInfoReq {
    private String keyword;
    private RequestPagination pagination;
    private List<Integer> genders;
    private List<String> userIDs;
}
