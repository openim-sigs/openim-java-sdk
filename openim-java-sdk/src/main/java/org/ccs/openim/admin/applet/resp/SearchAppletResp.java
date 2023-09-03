package org.ccs.openim.admin.applet.resp;

import lombok.Data;
import org.ccs.openim.chat.vo.AppletInfo;

import java.util.List;

@Data
public class SearchAppletResp {
    private Integer total;
    private List<AppletInfo> applets;
}
