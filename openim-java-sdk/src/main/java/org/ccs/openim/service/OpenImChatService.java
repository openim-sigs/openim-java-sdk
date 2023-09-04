package org.ccs.openim.service;


import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.chat.OpenImChatRest;
import org.ccs.openim.chat.req.*;
import org.ccs.openim.chat.resp.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImChatService {
    @Resource
    private OpenImChatRest openImChatRest;

    /**
     * 发送验证码
     * routePath=/code/send
     *
     * @param req
     * @return
     */
    public OpenImResult<String> codeSend(SendVerifyCodeReq req) {
        return openImChatRest.codeSend(req);
    }

    /**
     * 校验验证码
     * routePath=/code/verify
     *
     * @param req
     * @return
     */
    public OpenImResult<String> codeVerify(VerifyCodeReq req) {
        return openImChatRest.codeVerify(req);
    }


    /**
     * 登入
     * routePath=/account/login
     *
     * @param loginReq
     * @return
     */
    public OpenImResult<LoginResp> login(LoginReq loginReq, String operationId) {
        return openImChatRest.login(loginReq, operationId);
    }

    /**
     * 注册
     * routePath=/account/register
     *
     * @param userReq
     * @return
     */
    public OpenImResult<UserRegisterResp> register(RegisterUserReq userReq) {
        return openImChatRest.register(userReq);
    }

    /**
     * 忘记密码
     * routePath=/password/reset
     *
     * @param req
     * @return
     */
    public OpenImResult<String> passwordReset(ResetPasswordReq req) {
        return openImChatRest.passwordReset(req);
    }

    /**
     * 修改密码
     * routePath=/password/change
     *
     * @param req
     * @return
     */
    public OpenImResult<String> passwordChange(OpenImToken openImToken, ChangePasswordReq req) {
        return openImChatRest.passwordChange(openImToken, req);
    }

    /**
     * 编辑个人资料
     * routePath=/user/update
     *
     * @param openImToken
     * @param req
     * @return
     */
    public OpenImResult<String> update(OpenImToken openImToken, UpdateUserInfoReq req) {
        return openImChatRest.update(openImToken, req);
    }

    /**
     * 获取用户所有信息
     * routePath=/user/find/full
     *
     * @param req
     * @return
     */
    public OpenImResult<FindUserFullInfoResp> findUserFull(OpenImToken openImToken, FindUserFullInfoReq req) {
        return openImChatRest.findUserFull(openImToken, req);
    }

    /**
     * 获取用户公开信息
     * routePath=/user/find/public
     *
     * @param req
     * @return
     */
    public OpenImResult<FindUserPublicInfoResp> findUserPublic(OpenImToken openImToken, FindUserPublicInfoReq req) {
        return openImChatRest.findUserPublic(openImToken, req);
    }

    /**
     * 搜索用户所有信息
     * routePath=/user/search/full
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchUserFullInfoResp> searchUserFull(OpenImToken openImToken, SearchUserFullInfoReq req) {
        return openImChatRest.searchUserFull(openImToken, req);
    }

    /**
     * 搜索用户公开信息
     * routePath=/user/search/public
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchUserPubliclInfoResp> searchUserPublic(OpenImToken openImToken, SearchUserPublicInfoReq req) {
        return openImChatRest.searchUserPublic(openImToken, req);
    }

    /**
     * 小程序列表
     * routePath=/applet/find
     *
     * @param req
     * @return
     */
    public OpenImResult<FindAppletResp> appletFind(OpenImToken openImToken, FindAppletReq req) {
        return openImChatRest.appletFind(openImToken, req);
    }

    /**
     * 获取客户端初始化配置
     * routePath=/client_config/get
     *
     * @param req
     * @return
     */
    public OpenImResult<GetClientConfigResp> getClientConfig(OpenImToken openImToken, GetClientConfigReq req) {
        return openImChatRest.getClientConfig(openImToken, req);
    }

    /**
     * routePath=/callback/open_im
     *
     * @param req
     * @return
     */
    public OpenImResult<String> callbackOpenIm(OpenImToken openImToken, OpenIMCallbackReq req) {
        return openImChatRest.callbackOpenIm(openImToken, req);
    }
}
