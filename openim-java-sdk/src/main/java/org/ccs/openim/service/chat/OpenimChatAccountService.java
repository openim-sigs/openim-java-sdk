package org.ccs.openim.service.chat;

import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.chat.OpenImChatAccountRest;
import org.ccs.openim.chat.account.req.*;
import org.ccs.openim.chat.account.resp.LoginResp;
import org.ccs.openim.chat.account.resp.UserRegisterResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenimChatAccountService {
    @Resource
    private OpenImChatAccountRest openImChatAccountRest;

    /**
     * 发送验证码
     * routePath=/code/send
     *
     * @param req
     * @return
     */
    public OpenImResult<String> codeSend(SendVerifyCodeReq req) {
        return openImChatAccountRest.codeSend(req);
    }

    /**
     * 校验验证码
     * routePath=/code/verify
     *
     * @param req
     * @return
     */
    public OpenImResult<String> codeVerify(VerifyCodeReq req) {
        return openImChatAccountRest.codeVerify(req);
    }


    /**
     * 登入
     * routePath=/account/login
     *
     * @param loginReq
     * @return
     */
    public OpenImResult<LoginResp> login(LoginReq loginReq, String operationId) {
        return openImChatAccountRest.login(loginReq, operationId);
    }

    /**
     * 注册
     * routePath=/account/register
     *
     * @param userReq
     * @return
     */
    public OpenImResult<UserRegisterResp> register(RegisterUserReq userReq) {
        return openImChatAccountRest.register(userReq);
    }

    /**
     * 忘记密码
     * routePath=/password/reset
     *
     * @param req
     * @return
     */
    public OpenImResult<String> passwordReset(ResetPasswordReq req) {
        return openImChatAccountRest.passwordReset(req);
    }

    /**
     * 修改密码
     * routePath=/password/change
     *
     * @param req
     * @return
     */
    public OpenImResult<String> passwordChange(OpenImToken openImToken, ChangePasswordReq req) {
        return openImChatAccountRest.passwordChange(openImToken, req);
    }
}
