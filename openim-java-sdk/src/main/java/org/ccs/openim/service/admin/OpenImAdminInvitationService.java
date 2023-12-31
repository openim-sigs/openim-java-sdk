package org.ccs.openim.service.admin;

import org.ccs.openim.admin.OpenImAdminInvitationCodeRest;
import org.ccs.openim.admin.invitationCode.req.AddInvitationCodeReq;
import org.ccs.openim.admin.invitationCode.req.DelInvitationCodeReq;
import org.ccs.openim.admin.invitationCode.req.GenInvitationCodeReq;
import org.ccs.openim.admin.invitationCode.req.SearchInvitationCodeReq;
import org.ccs.openim.admin.invitationCode.resp.SearchInvitationCodeResp;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.utils.ValidatorUtils;


public class OpenImAdminInvitationService {

    private OpenImAdminInvitationCodeRest openImAdminInvitationCodeRest = new OpenImAdminInvitationCodeRest();


    /**
     * 增加邀请码
     * addInvitationCode
     * routePath=/invitation_code/add
     *
     * @param req
     * @return
     */
    public OpenImResult<String> addInvitationCode(OpenImToken openImToken, AddInvitationCodeReq req) {
        ValidatorUtils.validate(req);
        return openImAdminInvitationCodeRest.addInvitationCode(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImAdminInvitationCodeRest.genInvitationCode(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImAdminInvitationCodeRest.delInvitationCode(openImToken, req);
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
        ValidatorUtils.validate(req);
        return openImAdminInvitationCodeRest.searchInvitationCode(openImToken, req);
    }

}
