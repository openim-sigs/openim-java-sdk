package org.ccs.openim.constants;

/**
 * 用户登录状态
 *
 * @author chenjh
 */
public enum LoginStatus {
    /**
     * 未登录
     */
    LOGOUT(1, "Logout"),
    /**
     * 登录中
     */
    LOGGING(2, "Logging"),
    /**
     * 已登录
     */
    LOGGED(3, "Logged");
    private final int status;
    private final String statusName;

    LoginStatus(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public int getStatus() {
        return status;
    }

    public static LoginStatus parse(int status) {
        switch (status) {
            case 1:
                return LOGOUT;
            case 2:
                return LOGGING;
            case 3:
                return LOGGED;
        }
        return null;
    }
}
