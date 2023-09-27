package org.ccs.openim.chat.user.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;


/**
 * @author chenjh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindUserPublicInfoReq {
    @NotEmpty
    private List<String> userIDs;
}
