package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.third.req.*;
import org.ccs.openim.api.third.resp.*;
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
public class OpenImApiThirdRest {
    public OpenImApiThirdRest() {
        this.init();
    }

    public static final ApiServerType SERVER_TYPE = ApiServerType.API;


    private OpenimConfig openimConfig;


    public void init() {
        this.openimConfig = OpenimUtils.getOpenimConfig();
    }

    /**
     * fcmUpdateToken
     * routePath=/third/fcm_update_token
     *
     * @param req
     * @return
     */
    public OpenImResult<String> fcmUpdateToken(OpenImToken openImToken, FcmUpdateTokenReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/third/fcm_update_token");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----fcmUpdateToken--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * setAppBadge
     * routePath=/third/set_app_badge
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setAppBadge(OpenImToken openImToken, SetAppBadgeReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/third/set_app_badge");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----setAppBadge--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * routePath=/third/object/part_limit
     *
     * @param req
     * @return
     */
    public OpenImResult<PartLimitResp> partLimit(OpenImToken openImToken, PartLimitReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/third/object/part_limit");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<PartLimitResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<PartLimitResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----partLimit--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * routePath=/third/object/part_size
     *
     * @param req
     * @return
     */
    public OpenImResult<PartSizeResp> partSize(OpenImToken openImToken, PartSizeReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/third/object/part_size");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<PartSizeResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<PartSizeResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----partSize--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * initiateMultipartUpload
     * routePath=/third/object/initiate_multipart_upload
     *
     * @param req
     * @return
     */
    public OpenImResult<InitiateMultipartUploadResp> initiateMultipartUpload(OpenImToken openImToken, InitiateMultipartUploadReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/third/object/initiate_multipart_upload");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<InitiateMultipartUploadResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<InitiateMultipartUploadResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----initiateMultipartUpload--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * authSign
     * routePath=/third/object/auth_sign
     *
     * @param req
     * @return
     */
    public OpenImResult<AuthSignResp> authSign(OpenImToken openImToken, AuthSignReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/third/object/auth_sign");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<AuthSignResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<AuthSignResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----authSign--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * completeMultipartUpload
     * routePath=/third/object/complete_multipart_upload
     *
     * @param req
     * @return
     */
    public OpenImResult<CompleteMultipartUploadResp> completeMultipartUpload(OpenImToken openImToken, CompleteMultipartUploadReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/third/object/complete_multipart_upload");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<CompleteMultipartUploadResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<CompleteMultipartUploadResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----completeMultipartUpload--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }

    /**
     * accessURL
     * routePath=/third/object/access_url
     *
     * @param req
     * @return
     */
    public OpenImResult<AccessURLResp> accessURL(OpenImToken openImToken, AccessURLReq req) {
        long time = System.currentTimeMillis();
        String apiUrl = openimConfig.getApiUrl(SERVER_TYPE);
        String url = CommUtils.appendUrl(apiUrl, "/third/object/access_url");


        String body = JSONUtil.toJsonStr(req);
        HttpResponse exchanges = HttpRequestUtils.exchange(url, body, OpenimUtils.apiHeaderMap(openImToken));

        OpenImResult<AccessURLResp> openImResult = JSONUtil.toBean(exchanges.body(), new TypeReference<OpenImResult<AccessURLResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----accessURL--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.body());
        }

        return openImResult;
    }
}
