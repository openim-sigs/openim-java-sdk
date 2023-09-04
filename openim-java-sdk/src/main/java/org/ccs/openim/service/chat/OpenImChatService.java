package org.ccs.openim.service.chat;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImChatService {

    @Resource
    private OpenimChatUserService openimChatUserService;
    @Resource
    private OpenimChatAccountService openimChatAccountService;
    @Resource
    private OpenImChatOtherService openImChatOtherService;

    public OpenimChatUserService user() {
        return openimChatUserService;
    }

    public OpenimChatAccountService account() {
        return openimChatAccountService;
    }

    public OpenImChatOtherService other() {
        return openImChatOtherService;
    }


}
