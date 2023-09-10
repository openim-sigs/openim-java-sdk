package org.ccs.openim.service.admin;

import org.ccs.openim.admin.OpenImAdminClientConfigRest;
import org.ccs.openim.admin.clientconfig.req.DelClientConfigReq;
import org.ccs.openim.admin.clientconfig.req.SetClientConfigReq;
import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImAdminClientConfigService {

    private OpenImAdminClientConfigRest openImAdminClientConfigRest = new OpenImAdminClientConfigRest();

    /**
     * 获取客户端初始化配置
     * routePath=/client_config/get
     *
     * @return
     */
    public OpenImResult<GetClientConfigResp> getClientConfig(OpenImToken openImToken) {
        return openImAdminClientConfigRest.getClientConfig(openImToken);
    }

    /**
     * 设置客户端初始化配置
     * routePath=/client_config/set
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setClientConfig(OpenImToken openImToken, SetClientConfigReq req) {
        ValidatorUtils.validate(req);
        return openImAdminClientConfigRest.setClientConfig(openImToken, req);
    }

    /**
     * 删除客户端初始化配置
     * routePath=/client_config/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delClientConfig(OpenImToken openImToken, DelClientConfigReq req) {
        ValidatorUtils.validate(req);
        return openImAdminClientConfigRest.delClientConfig(openImToken, req);
    }

}
