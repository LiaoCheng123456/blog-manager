package com.service.blog.paramenum;

/**
 * contains whether info
 * if is 0 then just no. else is yes
 */
public enum WhetherConstEnum {
    DELETE(0,1),READ(0,1);

    public int YES;
    public int NO;

    WhetherConstEnum(int YES, int NO) {
        this.YES = YES;
        this.NO = NO;
    }

    public int getYes() {
        return YES;
    }

    public void setYes(int YES) {
        this.YES = YES;
    }

    public int getNo() {
        return NO;
    }

    public void setNo(int NO) {
        this.NO = NO;
    }
}
