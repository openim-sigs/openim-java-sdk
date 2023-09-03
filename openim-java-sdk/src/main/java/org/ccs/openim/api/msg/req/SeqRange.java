package org.ccs.openim.api.msg.req;

import lombok.Data;

@Data
public class SeqRange {
    private String conversationID;
    private Long begin;
    private Long end;
    private Long num;
}
