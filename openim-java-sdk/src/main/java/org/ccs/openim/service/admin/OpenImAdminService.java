package org.ccs.openim.service.admin;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OpenImAdminService {

    @Resource
    private OpenImAdminUserService openImAdminUserService;
    @Resource
    private OpenImAdminAppletService openImAdminAppletService;

    @Resource
    private OpenImAdminForbiddenService openImAdminForbiddenService;
    @Resource
    private OpenImAdminInvitationService openImAdminInvitationService;


    public OpenImAdminUserService user() {
        return openImAdminUserService;
    }

    public OpenImAdminAppletService applet() {
        return openImAdminAppletService;
    }

    public OpenImAdminForbiddenService forbidden() {
        return openImAdminForbiddenService;
    }

    public OpenImAdminInvitationService invitation() {
        return openImAdminInvitationService;
    }
}
