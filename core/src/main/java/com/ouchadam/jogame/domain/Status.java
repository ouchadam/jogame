package com.ouchadam.jogame.domain;

public enum Status {
    ON, OFF, DISABLED;
    public static Status from(String status) {
        return Status.valueOf(status.toUpperCase());
    }
}
