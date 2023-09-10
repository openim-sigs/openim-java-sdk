package org.ccs.openim.chat.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileURL {
    private String filename;
    private String URL;
}
