package org.ccs.openim.api.third.resp;

import lombok.Data;

import java.util.List;

@Data
public class AuthSignResp {
    private String url;
    private List<KeyValues> query;
    private List<KeyValues> header;
    private List<SignPart> parts;
}
