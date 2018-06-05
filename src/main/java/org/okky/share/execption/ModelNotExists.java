package org.okky.share.execption;

public class ModelNotExists extends RuntimeException {
    public ModelNotExists(String message) {
        super(message);
    }
}
