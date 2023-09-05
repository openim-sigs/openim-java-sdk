package org.ccs.openim.chat.user.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author chenjh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindUserFullInfoReq {
    private List<String> userIDs;
}
