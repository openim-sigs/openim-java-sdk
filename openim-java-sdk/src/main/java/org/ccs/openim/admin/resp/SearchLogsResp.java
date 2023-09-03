package org.ccs.openim.admin.resp;

import lombok.Data;
import org.ccs.openim.admin.vo.LogInfo;

import java.util.List;

@Data
public class SearchLogsResp {
    private List<LogInfo> LogsInfos;
    private Long total;
}
