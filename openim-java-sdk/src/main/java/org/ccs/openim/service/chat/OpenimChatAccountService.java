package org.ccs.openim.service.chat;

import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.chat.OpenImChatAccountRest;
import org.ccs.openim.chat.account.req.*;
import org.ccs.openim.chat.account.resp.LoginResp;
import org.ccs.openim.chat.account.resp.UserRegisterResp;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenimChatAccountService {

    private OpenImChatAccountRest openImChatAccountRest = new OpenImChatAccountRest();

    /**
     * 发送验证码
     * routePath=/account/code/send
     *
     * @param req
     * @return
     */
    public OpenImResult<String> codeSend(SendVerifyCodeReq req, String operationId) {
        ValidatorUtils.validate(req);
        return openImChatAccountRest.codeSend(req, operationId);
    }

    /**
     * 校验验证码
     * routePath=/account/code/verify
     *
     * @param req
     * @return
     */
    public OpenImResult<String> codeVerify(VerifyCodeReq req, String operationId) {
        ValidatorUtils.validate(req);
        return openImChatAccountRest.codeVerify(req, operationId);
    }


    /**
     * 登入
     * routePath=/account/login
     *
     * @param loginReq
     * @return
     */
    public OpenImResult<LoginResp> login(LoginReq loginReq, String operationId) {
        ValidatorUtils.validate(loginReq);
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
        ValidatorUtils.validate(userReq);
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
        ValidatorUtils.validate(req);
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
        ValidatorUtils.validate(req);
        return openImChatAccountRest.passwordChange(openImToken, req);
    }
}
