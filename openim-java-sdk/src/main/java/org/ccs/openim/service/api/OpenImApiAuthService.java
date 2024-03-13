package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiAuthRest;
import org.ccs.openim.api.auth.req.ForceLogoutReq;
import org.ccs.openim.api.auth.req.GetUserTokenReq;
import org.ccs.openim.api.auth.req.ParseTokenReq;
import org.ccs.openim.api.auth.req.UserTokenReq;
import org.ccs.openim.api.auth.resp.ParseTokenResp;
import org.ccs.openim.api.auth.resp.UserTokenResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImApiAuthService {

    private OpenImApiAuthRest openImApiAuthRest = new OpenImApiAuthRest();

    /**
     * 生成token
     * routePath=/auth/user_token
     *
     * @param req
     * @return
     */
    public OpenImResult<UserTokenResp> userToken(OpenImToken openImToken, UserTokenReq req) {
        ValidatorUtils.validate(req);
        return openImApiAuthRest.userToken(openImToken, req);
    }

    /**
     * 管理员获取用户 token
     * routePath=/auth/get_user_token
     *
     * @param req
     * @return
     */
    public OpenImResult<GetUserTokenReq> getUserToken(OpenImToken openImToken, GetUserTokenReq req){
        ValidatorUtils.validate(req);
        return openImApiAuthRest.getUserToken(openImToken, req);
    }

    /**
     * 解析token
     * routePath=/auth/parse_token
     *
     * @param req
     * @return
     */
    public OpenImResult<ParseTokenResp> parseToken(OpenImToken openImToken, ParseTokenReq req) {
        ValidatorUtils.validate(req);
        return openImApiAuthRest.parseToken(openImToken, req);
    }

    /**
     * 强制退出登录
     * routePath=/auth/force_logout
     *
     * @param req
     * @return
     */
    public OpenImResult<String> forceLogout(OpenImToken openImToken, ForceLogoutReq req) {
        ValidatorUtils.validate(req);
        return openImApiAuthRest.forceLogout(openImToken, req);
    }
}
