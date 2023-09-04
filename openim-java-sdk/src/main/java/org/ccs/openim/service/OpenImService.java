package org.ccs.openim.service;

import org.ccs.openim.service.admin.OpenImAdminService;
import org.ccs.openim.service.api.OpenImApiService;
import org.ccs.openim.service.chat.OpenImChatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 接口服务
 */
@Service
public class OpenImService {

    @Resource
    private OpenImApiService openImApiService;
    @Resource
    private OpenImAdminService openImAdminService;
    @Resource
    private OpenImChatService openImChatService;


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
