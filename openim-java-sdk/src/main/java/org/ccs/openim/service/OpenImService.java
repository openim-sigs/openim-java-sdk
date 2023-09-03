package org.ccs.openim.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 接口服务
 */
@Service
public class OpenImService {
    @Resource
    private OpenImApiUserService openImApiUserService;
    @Resource
    private OpenImApiAuthService openImApiAuthService;
    @Resource
    private OpenImApiGroupService openImApiGroupService;
    @Resource
    private OpenImApiFriendService openImApiFriendService;
    @Resource
    private OpenImApiMsgService openImApiMsgService;
    @Resource
    private OpenImApiStatisticsService openImApiStatisticsService;

    @Resource
    private OpenImApiConversationService openImApiConversationService;


    @Resource
    private OpenImChatService openImChatService;


    @Resource
    private OpenImAdminService openImAdminService;

    /**
     * 用户
     * routePath=/user/**
     *
     * @return
     */
    public OpenImApiUserService apiUser() {
        return openImApiUserService;
    }

    /**
     * 群组
     * routePath=/group/**
     *
     * @return
     */
    public OpenImApiGroupService apiGroup() {
        return openImApiGroupService;
    }

    /**
     * auth
     * routePath=/auth/**
     *
     * @return
     */
    public OpenImApiAuthService apiAuth() {
        return openImApiAuthService;
    }

    /**
     * 好友
     * routePath=/friend/**
     *
     * @return
     */
    public OpenImApiFriendService apiFriend() {
        return openImApiFriendService;
    }

    /**
     * 统计
     * routePath=/statistics/**
     *
     * @return
     */
    public OpenImApiStatisticsService apiStatistics() {
        return openImApiStatisticsService;
    }

    /**
     * routePath=/conversation/**
     *
     * @return
     */
    public OpenImApiConversationService apiConversation() {
        return openImApiConversationService;
    }

    /**
     * 消息
     *
     * @return
     */
    public OpenImApiMsgService apiMsg() {
        return openImApiMsgService;
    }

    public OpenImChatService chat() {
        return openImChatService;
    }

    public OpenImAdminService admin() {
        return openImAdminService;
    }

}
