package org.ccs.openim.api.user.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import java.util.List;

@Data
public class GetAllUserIDReq {
    private RequestPagination pagination;
    private List<String> userIDs;
}
