package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.group.req.GetGroupAbstractInfoReq;
import org.ccs.openim.api.group.resp.GetGroupAbstractInfoResp;
import org.ccs.openim.api.superGroup.req.GetJoinedSuperGroupListReq;
import org.ccs.openim.api.superGroup.resp.GetJoinedSuperGroupListResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;

/**
 * Open-IM-Server服务接口
 *
 * @author chenjh
 */
@Slf4j
public class OpenImApiSuperGroupRest {
    public OpenImApiSuperGroupRest() {
        this.init();
    }


    public static final ApiServerType SERVER_TYPE = ApiServerType.API;
    
    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 获取某个用户加入的超级群
     * routePath=/super_group/get_joined_group_list
     *
     * @param req
     * @return
     */
    public OpenImResult<GetJoinedSuperGroupListResp> getJoinedSuperGroupList(OpenImToken openImToken, GetJoinedSuperGroupListReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/super_group/get_joined_group_list");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetJoinedSuperGroupListResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetJoinedSuperGroupListResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getJoinedSuperGroupList--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 获取群信息hash值
     * routePath=/super_group/get_groups_info
     *
     * @param req
     * @return
     */
    public OpenImResult<GetGroupAbstractInfoResp> getGroupAbstractInfo(OpenImToken openImToken, GetGroupAbstractInfoReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/super_group/get_groups_info");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<GetGroupAbstractInfoResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<GetGroupAbstractInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getGroupAbstractInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
