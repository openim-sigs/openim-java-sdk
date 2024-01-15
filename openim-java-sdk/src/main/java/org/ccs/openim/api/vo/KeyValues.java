package org.ccs.openim.api.vo;

import lombok.Data;

import java.util.List;

@Data
public class KeyValues {
    private String key;
    private List<String> values;
}
