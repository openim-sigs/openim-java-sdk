package org.ccs.openim.admin.defaultGroup.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddDefaultGroupReq {
    @NotEmpty
    private List<String> groupIDs;
}
