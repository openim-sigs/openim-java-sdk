package org.ccs.openimdemo;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import junit.framework.TestCase;
import org.ccs.openim.admin.clientconfig.resp.GetClientConfigResp;
import org.ccs.openim.admin.forbidden.req.AddIPForbiddenReq;
import org.ccs.openim.admin.forbidden.req.IPForbiddenAdd;
import org.ccs.openim.admin.forbidden.req.SearchIPForbiddenReq;
import org.ccs.openim.admin.forbidden.resp.SearchIPForbiddenResp;
import org.ccs.openim.account.req.AdminLoginReq;
import org.ccs.openim.admin.req.UserLoginCountReq;
import org.ccs.openim.admin.req.UserRegisterCountReq;
import org.ccs.openim.admin.resp.AdminLoginResp;
import org.ccs.openim.admin.resp.NewUserCountResp;
import org.ccs.openim.admin.resp.UserLoginCountResp;
import org.ccs.openim.api.conversation.req.GetAllConversationsReq;
import org.ccs.openim.api.conversation.resp.GetAllConversationsResp;
import org.ccs.openim.api.friend.req.GetPaginationFriendsReq;
import org.ccs.openim.api.friend.resp.GetPaginationFriendsResp;
import org.ccs.openim.api.msg.req.GetServerTimeReq;
import org.ccs.openim.api.msg.resp.GetServerTimeResp;
import org.ccs.openim.api.statistics.resp.UserRegisterCountResp;
import org.ccs.openim.api.user.req.GetUsersOnlineStatusReq;
import org.ccs.openim.api.user.resp.GetUsersOnlineStatusResp_SuccessResult;
import org.ccs.openim.api.user.resp.SingleDetail;
import org.ccs.openim.base.OpenImResult;
import org.ccs.openim.base.OpenImToken;
import org.ccs.openim.base.RequestPagination;
import org.ccs.openim.chat.account.req.LoginReq;
import org.ccs.openim.chat.account.req.SendVerifyCodeReq;
import org.ccs.openim.chat.account.req.VerifyCodeReq;
import org.ccs.openim.chat.account.resp.LoginResp;
import org.ccs.openim.constants.IMPlatform;
import org.ccs.openim.constants.LimitIpType;
import org.ccs.openim.constants.VerificationCodeType;
import org.ccs.openim.service.OpenImService;
import org.ccs.openim.utils.OpenimUtils;
import org.ccs.openimdemo.config.OpenimConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OpenimDemoApplication.class)
@ActiveProfiles(value = {"openim", "dev"})
public class OpenImServiceTest {

    private OpenImService openImService = new OpenImService();

    private static OpenImToken openImToken;

    @Resource
    private OpenimConfiguration openimConfiguration;

    @Before
    public void initToken() {
        if (openImToken == null) {
            OpenimUtils.setOpenimConfig(openimConfiguration);
//            loginChat();
            adminLoginInit();
        }
    }

    private void loginChat() {
        String operationId = IdUtil.fastUUID();
        LoginReq loginReq = new LoginReq();
        loginReq.setPlatform(5);
        loginReq.setAreaCode("+86");
        loginReq.setPhoneNumber("17607559255");
        loginReq.setPassword("16d7a4fca7442dda3ad93c9a726597e4");
        OpenImResult<LoginResp> result = openImService.chat().account().login(loginReq, operationId);
        if (result.isOk()) {
            LoginResp loginResp = result.getData();
            openImToken = new OpenImToken(operationId, loginResp.getImToken(), loginResp.getChatToken(), null, loginResp.getUserID());
        }
    }

    private void adminLoginInit() {
        String operationId = IdUtil.fastUUID();
        AdminLoginReq adminLoginReq = new AdminLoginReq();
        adminLoginReq.setAccount("openIMAdmin");
        adminLoginReq.setPassword("de84e3477e4fcddc54c9bfbeac4aca2d");
        OpenImResult<AdminLoginResp> result = openImService.admin().user().adminLogin(adminLoginReq, operationId);
        if (result.isOk()) {
            AdminLoginResp loginResp = result.getData();
            openImToken = new OpenImToken(operationId, loginResp.getImToken(), null, loginResp.getAdminToken(), loginResp.getImUserID());
        }
    }

    @Test
    public void codeSend() {
        SendVerifyCodeReq req = new SendVerifyCodeReq();
        req.setPlatform(IMPlatform.WEB.getType());
//        req.setInvitationCode("+86");
        req.setAreaCode("+86");
        req.setPhoneNumber("17607559255");
        req.setUsedFor(VerificationCodeType.Login.getType());
        OpenImResult result = openImService.chat().account().codeSend(req, openImToken.getOperationId());
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void codeVerify() {
        VerifyCodeReq req = new VerifyCodeReq();
        req.setVerifyCode("666666");
        req.setAreaCode("+86");
        req.setPhoneNumber("17607559255");
        OpenImResult result = openImService.chat().account().codeVerify(req, openImToken.getOperationId());
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }


    @Test
    public void adminLogin() {
        String operationId = IdUtil.fastUUID();
        AdminLoginReq adminLoginReq = new AdminLoginReq();
        adminLoginReq.setAccount("openIMAdmin");
        adminLoginReq.setPassword("de84e3477e4fcddc54c9bfbeac4aca2d");
        OpenImResult<AdminLoginResp> result = openImService.admin().user().adminLogin(adminLoginReq, operationId);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getUsersOnlineStatus() {
        GetUsersOnlineStatusReq req = new GetUsersOnlineStatusReq();
        req.setUserIDs(Arrays.asList(openImToken.getUserId()));
        OpenImResult<List<GetUsersOnlineStatusResp_SuccessResult>> result = openImService.api().user().getUsersOnlineStatus(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getUsersOnlineTokenDetail() {
        GetUsersOnlineStatusReq req = new GetUsersOnlineStatusReq();
        req.setUserIDs(Arrays.asList(openImToken.getUserId()));
        OpenImResult<List<SingleDetail>> result = openImService.api().user().getUsersOnlineTokenDetail(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getClientConfig() {
        OpenImResult<GetClientConfigResp> result = openImService.admin().clientConfig().getClientConfig(openImToken);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void newUserCount() {
        UserRegisterCountReq req = new UserRegisterCountReq();
        Long curTime = System.currentTimeMillis();
        req.setStart(curTime - 864000 * 1000 * 3);
        req.setEnd(curTime);
        OpenImResult<NewUserCountResp> result = openImService.admin().user().newUserCount(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void loginUserCount() {
        UserLoginCountReq req = new UserLoginCountReq();
        Long curTime = System.currentTimeMillis();
        req.setStart(curTime - 864000 * 1000 * 3);
        req.setEnd(curTime);
        OpenImResult<UserLoginCountResp> result = openImService.admin().user().loginUserCount(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void userRegisterCount() {
        UserRegisterCountReq req = new UserRegisterCountReq();
        Long curTime = System.currentTimeMillis();

        req.setStart(curTime);
        req.setEnd(curTime - 864000 * 1000 * 3);
        OpenImResult<UserRegisterCountResp> result = openImService.api().statistics().userRegisterCount(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }


    @Test
    public void getAllConversations() {
        GetAllConversationsReq req = new GetAllConversationsReq();
        req.setOwnerUserID(openImToken.getUserId());
        OpenImResult<GetAllConversationsResp> result = openImService.api().conversation().getAllConversations(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getFriendList() {
        GetPaginationFriendsReq req = new GetPaginationFriendsReq();
        req.setUserID(openImToken.getUserId());
        req.setPagination(new RequestPagination(1, 10));
        OpenImResult<GetPaginationFriendsResp> result = openImService.api().friend().getFriendList(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void addIPForbidden() {
        AddIPForbiddenReq req = new AddIPForbiddenReq();
        req.setForbiddens(Arrays.asList(new IPForbiddenAdd("192.168.0.200", true, true)));
        OpenImResult<String> result = openImService.admin().forbidden().addIPForbidden(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void searchIPForbidden() {
        SearchIPForbiddenReq req = new SearchIPForbiddenReq();
        req.setPagination(new RequestPagination(1, 10));
        req.setKeyword("192.168");
        req.setStatus(LimitIpType.NIL.getType());
        OpenImResult<SearchIPForbiddenResp> result = openImService.admin().forbidden().searchIPForbidden(openImToken, req);
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }

    @Test
    public void getServerTime() {
        OpenImResult<GetServerTimeResp> result = openImService.api().msg().getServerTime(openImToken, new GetServerTimeReq());
        System.out.println(JSONUtil.toJsonStr(result));
        TestCase.assertTrue(result.getErrMsg(), result.isOk());
    }
}
