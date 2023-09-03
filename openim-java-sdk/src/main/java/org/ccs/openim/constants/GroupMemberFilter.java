package org.ccs.openim.constants;

/**
 * 筛选成员类型
 *
 * @author chenjh
 */
public enum GroupMemberFilter {
    /**
     * All 所有，查询可用
     */
    ALL(0, "All"),
    /**
     * Owner 群主
     */
    OWNER(1, "Owner"),
    /**
     * Admin 群管理员
     */
    ADMIN(2, "Admin"),
    /**
     * Nomal 群成员
     */
    NOMAL(3, "Nomal"),
    /**
     * AdminAndNomal 管理员和成员
     */
    AdminAndNomal(4, "AdminAndNomal"),
    /**
     * AdminAndOwner 群主和管理员
     */
    AdminAndOwner(5, "AdminAndOwner");
    private final int type;
    private final String statusName;

    GroupMemberFilter(int type, String statusName) {
        this.type = type;
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public int getType() {
        return type;
    }

    public static GroupMemberFilter parse(int type) {
        switch (type) {
            case 0:
                return ALL;
            case 1:
                return OWNER;
            case 2:
                return ADMIN;
            case 3:
                return NOMAL;
            case 4:
                return AdminAndNomal;
            case 5:
                return AdminAndOwner;
        }
        return null;
    }
}
