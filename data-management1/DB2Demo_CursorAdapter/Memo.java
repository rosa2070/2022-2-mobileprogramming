package org.techtown.db1demo;

public class Memo {
    private long id;
    private String memo;

    public Memo(long id, String s) {
        this.id = id;
        this.memo = s;
    }

    public long getId() {
        return id;
    }

    public void setS(String s) {
        this.memo = s;
    }

    @Override
    public String toString() {
        return memo;
    }
}
