package org.ccs.openim.account.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import java.util.List;

@Data
public class SearchAdminAccountReq {
    private RequestPagination pagination;
}
