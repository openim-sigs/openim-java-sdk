package org.ccs.openim.admin.applet.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import jakarta.validation.constraints.NotNull;

@Data
public class SearchAppletReq {
    private String keyword;
    @NotNull
    private RequestPagination pagination;
}
