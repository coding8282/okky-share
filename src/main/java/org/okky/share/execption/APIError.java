package org.okky.share.execption;

import lombok.Getter;

import static java.lang.String.format;

@Getter
public class APIError {
    String service;
    String code;
    String message;
    String moreInfo;

    public APIError(String service, String code, String message) {
        this.service = service;
        this.code = code;
        this.message = message;
        this.moreInfo = format("http://dev.okky.org/errors/%s", code);
    }
}
