package org.ccs.openim.admin;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.admin.invitationCode.req.AddInvitationCodeReq;
import org.ccs.openim.admin.invitationCode.req.DelInvitationCodeReq;
import org.ccs.openim.admin.invitationCode.req.GenInvitationCodeReq;
import org.ccs.openim.admin.invitationCode.req.SearchInvitationCodeReq;
import org.ccs.openim.admin.invitationCode.resp.SearchInvitationCodeResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.HttpRequestUtils;
import org.ccs.openim.utils.OpenimUtils;

/**
 * openIm-chat.admin服务接口
 *
 * @author chenjh
 */

@Slf4j
public class OpenImAdminInvitationCodeRest {
    public OpenImAdminInvitationCodeRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.ADMIN;

    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * 增加邀请码
     * addInvitationCode
     * routePath=/invitation_code/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addInvitationCode(OpenImToken openImToken, AddInvitationCodeReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/invitation_code/add");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----addInvitationCode--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 生成邀请码
     * genInvitationCode
     * routePath=/invitation_code/gen
     *
     * @param req
     * @return
     */
    public OpenImResult<String> genInvitationCode(OpenImToken openImToken, GenInvitationCodeReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/invitation_code/gen");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----genInvitationCode--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 删除邀请码
     * delInvitationCode
     * routePath=/invitation_code/del
     *
     * @param req
     * @return
     */
    public OpenImResult<String> delInvitationCode(OpenImToken openImToken, DelInvitationCodeReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/invitation_code/del");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----delInvitationCode--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * 查询邀请码
     * searchInvitationCode
     * routePath=/invitation_code/search
     *
     * @param req
     * @return
     */
    public OpenImResult<SearchInvitationCodeResp> searchInvitationCode(OpenImToken openImToken, SearchInvitationCodeReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/invitation_code/search");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.adminHeaderMap(openImToken));

        OpenImResult<SearchInvitationCodeResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<SearchInvitationCodeResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----searchInvitationCode--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }


}
