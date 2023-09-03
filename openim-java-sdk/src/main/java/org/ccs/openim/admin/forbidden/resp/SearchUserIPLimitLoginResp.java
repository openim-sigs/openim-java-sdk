package org.ccs.openim.admin.forbidden.resp;

import lombok.Data;

import java.util.List;

@Data
public class SearchUserIPLimitLoginResp {
    private Integer total;
    private List<LimitUserLoginIP> limits;

}
