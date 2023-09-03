package org.ccs.openim.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenjh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenImToken {
    private String operationId;
    private String imToken;
    private String chatToken;
    private String adminToken;
    private String userId;
}
