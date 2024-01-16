package org.ccs.openim.service.admin;

public class OpenImAdminService {

    private final OpenImAdminUserService openImAdminUserService = new OpenImAdminUserService();

    private final OpenImAdminAppletService openImAdminAppletService = new OpenImAdminAppletService();

    private final OpenImAdminForbiddenService openImAdminForbiddenService = new OpenImAdminForbiddenService();

    private final OpenImAdminInvitationService openImAdminInvitationService = new OpenImAdminInvitationService();

    private final OpenImAdminDefaultUserService openImAdminDefaultUserService = new OpenImAdminDefaultUserService();

    private final OpenImAdminDefaultGroupService openImAdminDefaultGroupService = new OpenImAdminDefaultGroupService();

    private final OpenImAdminClientConfigService openImAdminClientConfigService = new OpenImAdminClientConfigService();

    private final OpenImAdminAccountService openImAdminAccountService = new OpenImAdminAccountService();


    public OpenImAdminUserService user() {
        return openImAdminUserService;
    }

    public OpenImAdminAccountService account(){
        return openImAdminAccountService;
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
