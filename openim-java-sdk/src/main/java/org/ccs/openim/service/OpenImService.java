package org.ccs.openim.service;

import org.ccs.openim.service.admin.OpenImAdminService;
import org.ccs.openim.service.api.OpenImApiService;
import org.ccs.openim.service.chat.OpenImChatService;

/**
 * 接口服务
 */
public class OpenImService {

    private OpenImApiService openImApiService = new OpenImApiService();

    private OpenImAdminService openImAdminService = new OpenImAdminService();

    private OpenImChatService openImChatService = new OpenImChatService();


    public OpenImChatService chat() {
        return openImChatService;
    }

    public OpenImApiService api() {
        return openImApiService;
    }

    public OpenImAdminService admin() {
        return openImAdminService;
    }
}
