package org.ccs.openim.service.chat;


import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.chat.OpenImChatOtherRest;
import org.ccs.openim.chat.req.FindAppletReq;
import org.ccs.openim.chat.req.GetClientConfigReq;
import org.ccs.openim.chat.req.OpenIMCallbackReq;
import org.ccs.openim.chat.req.UploadLogsReq;
import org.ccs.openim.chat.resp.FindAppletResp;


public class OpenImChatOtherService {
    private OpenImChatOtherRest openImChatOtherRest = new OpenImChatOtherRest();


    /**
     * 小程序列表
     * routePath=/applet/find
     *
     * @param req
     * @return
     */
    public OpenImResult<FindAppletResp> appletFind(OpenImToken openImToken, FindAppletReq req) {
        return openImChatOtherRest.appletFind(openImToken, req);
    }

    /**
     * 获取客户端初始化配置
     * routePath=/client_config/get
     *
     * @param req
     * @return
     */
    public OpenImResult<GetClientConfigResp> getClientConfig(OpenImToken openImToken, GetClientConfigReq req) {
        return openImChatOtherRest.getClientConfig(openImToken, req);
    }

    /**
     * routePath=/callback/open_im
     *
     * @param req
     * @return
     */
    public OpenImResult<String> callbackOpenIm(OpenImToken openImToken, OpenIMCallbackReq req) {
        return openImChatOtherRest.callbackOpenIm(openImToken, req);
    }

    /**
     * 上传日志
     * routePath = /logs/upload
     *
     * @param req
     * @return
     */
    public OpenImResult<String> uploadLogs(OpenImToken openImToken, UploadLogsReq req){
        return openImChatOtherRest.uploadLogs(openImToken, req);
    }
}
