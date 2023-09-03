package org.ccs.openim.api.third.resp;

import lombok.Data;

import java.util.List;

@Data
public class SignPart {
    private Integer partNumber;
    private String  url;
    private List<KeyValues> query;
    private List<KeyValues> header;
}
