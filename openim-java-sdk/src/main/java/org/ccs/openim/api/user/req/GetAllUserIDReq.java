package org.ccs.openim.api.user.req;

import lombok.Data;
import org.ccs.openim.base.RequestPagination;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class GetAllUserIDReq {
    @NotEmpty
    private List<String> userIDs;
    @NotNull
    private RequestPagination pagination;
}
