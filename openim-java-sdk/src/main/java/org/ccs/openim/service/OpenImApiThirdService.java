package org.ccs.openim.service;

import org.ccs.openim.api.OpenImApiThirdRest;
import org.ccs.openim.api.third.req.*;
import org.ccs.openim.api.third.resp.*;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImApiThirdService {
    @Resource
    private OpenImApiThirdRest openImApiThirdRest;

    /**
     * fcmUpdateToken
     * routePath=/third/fcm_update_token
     *
     * @param req
     * @return
     */
    public OpenImResult<String> fcmUpdateToken(OpenImToken openImToken, FcmUpdateTokenReq req) {
        return openImApiThirdRest.fcmUpdateToken(openImToken, req);
    }

    /**
     * setAppBadge
     * routePath=/third/set_app_badge
     *
     * @param req
     * @return
     */
    public OpenImResult<String> setAppBadge(OpenImToken openImToken, SetAppBadgeReq req) {
        return openImApiThirdRest.setAppBadge(openImToken, req);
    }

    /**
     * routePath=/third/object/part_limit
     *
     * @param req
     * @return
     */
    public OpenImResult<PartLimitResp> partLimit(OpenImToken openImToken, PartLimitReq req) {
        return openImApiThirdRest.partLimit(openImToken, req);
    }

    /**
     * routePath=/third/object/part_size
     *
     * @param req
     * @return
     */
    public OpenImResult<PartSizeResp> partSize(OpenImToken openImToken, PartSizeReq req) {
        return openImApiThirdRest.partSize(openImToken, req);
    }

    /**
     * initiateMultipartUpload
     * routePath=/third/object/initiate_multipart_upload
     *
     * @param req
     * @return
     */
    public OpenImResult<InitiateMultipartUploadResp> initiateMultipartUpload(OpenImToken openImToken, InitiateMultipartUploadReq req) {
        return openImApiThirdRest.initiateMultipartUpload(openImToken, req);
    }

    /**
     * completeMultipartUpload
     * routePath=/third/object/complete_multipart_upload
     *
     * @param req
     * @return
     */
    public OpenImResult<CompleteMultipartUploadResp> completeMultipartUpload(OpenImToken openImToken, CompleteMultipartUploadReq req) {
        return openImApiThirdRest.completeMultipartUpload(openImToken, req);
    }

    /**
     * accessURL
     * routePath=/third/object/access_url
     *
     * @param req
     * @return
     */
    public OpenImResult<AccessURLResp> accessURL(OpenImToken openImToken, AccessURLReq req) {
        return openImApiThirdRest.accessURL(openImToken, req);
    }
}
