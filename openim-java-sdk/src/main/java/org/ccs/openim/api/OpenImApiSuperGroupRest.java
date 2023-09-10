package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.group.req.GetGroupAbstractInfoReq;
import org.ccs.openim.api.group.resp.GetGroupAbstractInfoResp;
import org.ccs.openim.api.superGroup.req.GetJoinedSuperGroupListReq;
import org.ccs.openim.api.superGroup.resp.GetJoinedSuperGroupListResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;
import org.springframework.http.*;

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


    private HttpHeaders initPostHeader(OpenImToken openImToken) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("authKey", openimConfig.getAuthKey());
        requestHeaders.add(OpenimParams.OPERATIONID, openImToken.getOperationId());
        requestHeaders.add(OpenimParams.TOKEN, openImToken.getImToken());
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return requestHeaders;
    }

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


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetJoinedSuperGroupListResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetJoinedSuperGroupListResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getJoinedSuperGroupList--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);

        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = HttpRequestUtils.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<GetGroupAbstractInfoResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<GetGroupAbstractInfoResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----getGroupAbstractInfo--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
