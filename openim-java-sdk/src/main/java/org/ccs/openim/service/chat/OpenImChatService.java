package org.ccs.openim.service.chat;

public class OpenImChatService {

    private final OpenimChatUserService openimChatUserService = new OpenimChatUserService();

    private final OpenimChatAccountService openimChatAccountService = new OpenimChatAccountService();

    private final OpenImChatOtherService openImChatOtherService = new OpenImChatOtherService();

    private final OpenImChatFriendService openImChatFriendService = new OpenImChatFriendService();

    public OpenimChatUserService user() {
        return openimChatUserService;
    }

    public OpenimChatAccountService account() {
        return openimChatAccountService;
    }

    public OpenImChatOtherService other() {
        return openImChatOtherService;
    }

    public OpenImChatFriendService friend() {
        return openImChatFriendService;
    }

}
