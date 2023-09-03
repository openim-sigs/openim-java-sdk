package org.ccs.openim.service.api;

import org.ccs.openim.api.OpenImApiAuthRest;
import org.ccs.openim.api.auth.req.ForceLogoutReq;
import org.ccs.openim.api.auth.req.ParseTokenReq;
import org.ccs.openim.api.auth.req.UserTokenReq;
import org.ccs.openim.api.auth.resp.ParseTokenResp;
import org.ccs.openim.api.auth.resp.UserTokenResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImApiAuthService {
    @Resource
    private OpenImApiAuthRest openImApiAuthRest;

    /**
     * 获取用户token
     * routePath=/auth/user_token
     *
     * @param req
     * @return
     */
    public OpenImResult<UserTokenResp> userToken(OpenImToken openImToken, UserTokenReq req) {
        return openImApiAuthRest.userToken(openImToken, req);
    }

    /**
     * 解析token
     * routePath=/auth/parse_token
     *
     * @param req
     * @return
     */
    public OpenImResult<ParseTokenResp> parseToken(OpenImToken openImToken, ParseTokenReq req) {
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
        return openImApiAuthRest.forceLogout(openImToken, req);
    }
}
