package org.ccs.openim.chat.resp;

import lombok.Data;
import org.ccs.openim.chat.vo.AppletInfo;

import java.util.List;

@Data
public class FindAppletResp {
    private List<AppletInfo> applets;
}
