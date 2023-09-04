package org.ccs.openim.service.admin;

public class OpenImAdminService {

    private OpenImAdminUserService openImAdminUserService = new OpenImAdminUserService();

    private OpenImAdminAppletService openImAdminAppletService = new OpenImAdminAppletService();

    private OpenImAdminForbiddenService openImAdminForbiddenService = new OpenImAdminForbiddenService();

    private OpenImAdminInvitationService openImAdminInvitationService = new OpenImAdminInvitationService();

    private OpenImAdminDefaultUserService openImAdminDefaultUserService = new OpenImAdminDefaultUserService();

    private OpenImAdminDefaultGroupService openImAdminDefaultGroupService = new OpenImAdminDefaultGroupService();

    private OpenImAdminClientConfigService openImAdminClientConfigService = new OpenImAdminClientConfigService();


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

    public OpenImAdminDefaultUserService defaultUser() {
        return openImAdminDefaultUserService;
    }

    public OpenImAdminDefaultGroupService defaultGroup() {
        return openImAdminDefaultGroupService;
    }

    public OpenImAdminClientConfigService clientConfig() {
        return openImAdminClientConfigService;
    }
}
