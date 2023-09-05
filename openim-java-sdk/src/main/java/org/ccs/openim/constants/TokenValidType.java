package org.ccs.openim.constants;

/**
 * Token有效类型
 *
 * @author chenjh
 */
public enum TokenValidType {
    /**
     * 正常
     */
    NormalToken(0, "NormalToken"),
    /**
     * 无效
     */
    InValidToken(1, "InValidToken"),
    /**
     * 被踢
     */
    KickedToken(2, "KickedToken"),
    /**
     * 过期
     */
    ExpiredToken(3, "ExpiredToken");
    private final int type;
    private final String typeName;

    TokenValidType(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getType() {
        return type;
    }

    public static TokenValidType parse(int type) {
        switch (type) {
            case 0:
                return NormalToken;
            case 1:
                return InValidToken;
            case 2:
                return KickedToken;
            case 3:
                return ExpiredToken;
            default:
                return null;
        }
    }
}
