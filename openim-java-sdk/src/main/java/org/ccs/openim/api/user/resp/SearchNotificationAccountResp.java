package org.ccs.openim.api.user.resp;

import lombok.Data;
import org.ccs.openim.api.vo.NotificationAccountInfo;

import java.util.List;

@Data
public class SearchNotificationAccountResp {
    private List<NotificationAccountInfo> notificationAccounts;
}
