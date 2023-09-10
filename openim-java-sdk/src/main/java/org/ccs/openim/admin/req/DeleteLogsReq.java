package org.ccs.openim.admin.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteLogsReq {
    @NotEmpty
    private List<String> logIDs;
}
