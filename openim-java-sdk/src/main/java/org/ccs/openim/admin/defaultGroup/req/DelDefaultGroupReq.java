package org.ccs.openim.admin.defaultGroup.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DelDefaultGroupReq {
    private List<String> groupIDs;
}
