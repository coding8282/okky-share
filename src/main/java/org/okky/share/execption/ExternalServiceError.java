package org.okky.share.execption;

public class ExternalServiceError extends RuntimeException {
    public ExternalServiceError(String message) {
        super(message);
    }

    public ExternalServiceError(byte[] bytes) {
        this(new String(bytes));
    }
}
