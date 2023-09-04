package org.ccs.openim.service.api;

public class OpenImApiService {

    private OpenImApiUserService openImApiUserService = new OpenImApiUserService();

    private OpenImApiAuthService openImApiAuthService = new OpenImApiAuthService();

    private OpenImApiGroupService openImApiGroupService = new OpenImApiGroupService();

    private OpenImApiFriendService openImApiFriendService = new OpenImApiFriendService();

    private OpenImApiMsgService openImApiMsgService = new OpenImApiMsgService();

    private OpenImApiStatisticsService openImApiStatisticsService = new OpenImApiStatisticsService();

    private OpenImApiConversationService openImApiConversationService = new OpenImApiConversationService();

    private OpenImApiThirdService openImApiThirdService = new OpenImApiThirdService();

    /**
     * 用户
     * routePath=/user/**
     *
     * @return
     */
    public OpenImApiUserService user() {
        return openImApiUserService;
    }

    /**
     * 群组
     * routePath=/group/**
     *
     * @return
     */
    public OpenImApiGroupService group() {
        return openImApiGroupService;
    }

    /**
     * auth
     * routePath=/auth/**
     *
     * @return
     */
    public OpenImApiAuthService auth() {
        return openImApiAuthService;
    }

    /**
     * 好友
     * routePath=/friend/**
     *
     * @return
     */
    public OpenImApiFriendService friend() {
        return openImApiFriendService;
    }

    /**
     * 统计
     * routePath=/statistics/**
     *
     * @return
     */
    public OpenImApiStatisticsService statistics() {
        return openImApiStatisticsService;
    }

    /**
     * routePath=/conversation/**
     *
     * @return
     */
    public OpenImApiConversationService conversation() {
        return openImApiConversationService;
    }

    /**
     * 消息
     * routePath=/msg/**
     *
     * @return
     */
    public OpenImApiMsgService msg() {
        return openImApiMsgService;
    }

    /**
     * 消息
     * routePath=/third/**
     *
     * @return
     */
    public OpenImApiThirdService third() {
        return openImApiThirdService;
    }
}
