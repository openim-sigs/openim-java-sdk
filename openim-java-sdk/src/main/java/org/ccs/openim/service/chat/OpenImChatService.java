package org.ccs.openim.service.chat;

public class OpenImChatService {

    private OpenimChatUserService openimChatUserService = new OpenimChatUserService();

    private OpenimChatAccountService openimChatAccountService = new OpenimChatAccountService();

    private OpenImChatOtherService openImChatOtherService = new OpenImChatOtherService();

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
