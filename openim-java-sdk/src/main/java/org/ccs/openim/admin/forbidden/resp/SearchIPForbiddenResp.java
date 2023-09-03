package org.ccs.openim.admin.forbidden.resp;

import lombok.Data;

import java.util.List;

@Data
public class SearchIPForbiddenResp {
    private Integer total;
    private List<IPForbidden> forbiddens;
}
