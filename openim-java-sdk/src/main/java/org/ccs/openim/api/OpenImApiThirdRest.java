package org.ccs.openim.api;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.ccs.openim.api.third.req.*;
import org.ccs.openim.api.third.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.OpenimConfig;
import org.ccs.openim.base.OpenimParams;
import org.ccs.openim.constants.ApiServerType;
import org.ccs.openim.utils.CommUtils;
import org.ccs.openim.utils.OpenimUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * Open-IM-Server服务接口
 *
 * @author chenjh
 */
@Service
@Slf4j
public class OpenImApiThirdRest {
    @Autowired
    private RestTemplate restTemplate;

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

    @PostConstruct
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);


        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----fcmUpdateToken--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);


        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<String> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<String>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----setAppBadge--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);


        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<PartLimitResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<PartLimitResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----partLimit--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);


        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<PartSizeResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<PartSizeResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----partSize--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);


        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<InitiateMultipartUploadResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<InitiateMultipartUploadResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----initiateMultipartUpload--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);


        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<AuthSignResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<AuthSignResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----authSign--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);


        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<CompleteMultipartUploadResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<CompleteMultipartUploadResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----completeMultipartUpload--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
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


        HttpHeaders httpHeaders = initPostHeader(openImToken);


        String body = JSONUtil.toJsonStr(req);
        HttpEntity<String> formEntity = new HttpEntity<>(body, httpHeaders);
        ResponseEntity<String> exchanges = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);

        OpenImResult<AccessURLResp> openImResult = JSONUtil.toBean(exchanges.getBody(), new TypeReference<OpenImResult<AccessURLResp>>() {
        }, false);

        if (!openImResult.isOk()) {
            log.warn("----accessURL--body={} time={} result={}", body, System.currentTimeMillis() - time, exchanges.getBody());
        }

        return openImResult;
    }
}
