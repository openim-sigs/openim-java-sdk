package org.ccs.openim.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPagination {
    /**
     * 页数
     */
    private Integer pageNumber=1;
    /**
     * 每页行数
     */
    private Integer showNumber=10;
}
