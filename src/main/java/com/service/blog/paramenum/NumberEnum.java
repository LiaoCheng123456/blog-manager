package com.service.blog.paramenum;

public enum NumberEnum {
    ZERO_(0), SIXTEEN(16), SIZE_256(256);
    public int VALUE;

    NumberEnum(int value) {
        this.VALUE = value;
    }
}
