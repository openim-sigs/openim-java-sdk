package org.ccs.openim.constants;

/**
 * 群权限选项
 *
 * @author chenjh
 */
public enum GroupMemberRole {
    OWNER(100, "Owner"),
    ADMIN(60, "Admin"),
    NORMAL(20, "Normal");
    private final int level;
    private final String roleName;

    GroupMemberRole(int level, String roleName) {
        this.level = level;
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getLevel() {
        return level;
    }

    public static GroupMemberRole parse(int level){
        switch (level){
            case 100:
                return OWNER;
            case 60:
                return ADMIN;
            case 20:
                return NORMAL;
        }
        return null;
    }
}
