package org.ccs.openim.admin.invitationCode.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import java.util.List;

@Data
public class SearchInvitationCodeReq {
    private Integer status;
    private List<String> userIDs;
    private List<String> codes;

    private String keyword;
    private RequestPagination pagination;
}
