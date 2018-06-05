package org.okky.share.execption;

public class ModelConflicted extends RuntimeException {
    public ModelConflicted(String message) {
        super(message);
    }
}
