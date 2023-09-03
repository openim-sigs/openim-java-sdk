package org.ccs.openim.constants;

/**
 * 群状态
 *
 * @author chenjh
 */
public enum GroupStatus {
    /**
     * 正常
     */
    NORMAL(0, "Normal"),
    /**
     * 封禁
     */
    BANED(1, "Baned"),
    /**
     * 解散
     */
    DISMISSED(2, "Dismissed"),
    /**
     * 禁言
     */
    MUTED(3, "Muted");
    private final int status;
    private final String statusName;

    GroupStatus(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public int getStatus() {
        return status;
    }

    public static GroupStatus parse(int status) {
        switch (status) {
            case 0:
                return NORMAL;
            case 1:
                return BANED;
            case 2:
                return DISMISSED;
            case 3:
                return MUTED;
        }
        return null;
    }
}
