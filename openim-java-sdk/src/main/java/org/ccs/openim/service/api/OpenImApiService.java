package org.ccs.openim.service.api;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImApiService {
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
    private OpenImApiThirdService openImApiThirdService;

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
