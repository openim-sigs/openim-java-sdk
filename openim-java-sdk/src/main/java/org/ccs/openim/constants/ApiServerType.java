package org.ccs.openim.constants;

public enum ApiServerType {
    /**
     * IM群组用户api服务器地址
     * 本地服务端口: 10002
     */
    API("api", "api"),
    /**
     * 登录注册服务器地址
     * 本地服务端口: 10008
     */
    CHAT("chat", "chat"),
    /**
     * admin地址
     * 本地服务端口10009
     */
    ADMIN("admin", "complete_admin");

    private final String type;
    private final String apiPath;

    ApiServerType(String type, String apiPath) {
        this.type = type;
        this.apiPath = apiPath;
    }

    public String getType() {
        return type;
    }

    public String getApiPath() {
        return apiPath;
    }

    public static ApiServerType parse(String type) {
        switch (type) {
            case "api":
                return API;
            case "chat":
                return CHAT;
            case "admin":
                return ADMIN;
        }
        return null;
    }
}
