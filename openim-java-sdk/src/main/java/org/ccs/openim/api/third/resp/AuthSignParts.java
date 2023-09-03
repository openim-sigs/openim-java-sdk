package org.ccs.openim.api.third.resp;

import lombok.Data;

import java.util.List;

@Data
public class AuthSignParts {
    private String url;
    private List<KeyValues> query;
    private List<KeyValues> header;
    private List<SignPart> parts;
}
