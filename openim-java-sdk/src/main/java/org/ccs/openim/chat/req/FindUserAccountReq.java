package org.ccs.openim.chat.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author chenjh
 */
@Data
public class FindUserAccountReq {
    @NotEmpty
    private List<String> userIDs;
}
