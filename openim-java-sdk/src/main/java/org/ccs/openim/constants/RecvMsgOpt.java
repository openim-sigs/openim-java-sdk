package org.ccs.openim.constants;

/**
 * 用户离线并且接入了如：个推、极光等第三方离线推送时，可以通过设置此选项来控制离线消息是否推送。
 *
 * @author chenjh
 */
public enum RecvMsgOpt {
    /**
     * 离线时会进行 APNs 推送
     */
    NORMAL(0, "Normal"),
    /**
     * 离线不会有推送通知
     */
    NOT_RECEIVE(1, "NotReceive"),
    /**
     * 离线不会有推送通知
     */
    NOT_NOTIFY(2, "NotNotify");
    private final int status;
    private final String statusName;

    RecvMsgOpt(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public int getStatus() {
        return status;
    }

    public static RecvMsgOpt parse(int status) {
        switch (status) {
            case 0:
                return NORMAL;
            case 2:
                return NOT_RECEIVE;
            case 3:
                return NOT_NOTIFY;
        }
        return null;
    }
}
