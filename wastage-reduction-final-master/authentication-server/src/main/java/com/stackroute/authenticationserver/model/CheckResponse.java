package com.stackroute.authenticationserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckResponse {

    private String str;

    public String getStr() {
        return str;
    }
}
