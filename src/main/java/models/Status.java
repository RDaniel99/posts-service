package models;

import java.util.Arrays;

public enum Status {

    PENDING_LOST,

    ACTIVE_LOST,

    PENDING_FOUND,

    ACTIVE_FOUND,

    SOLVED,

    CLOSED;


    Status() { }

    public boolean isActive() {

        return Arrays.asList(ACTIVE_LOST, ACTIVE_FOUND).contains(this);
    }

    public boolean isPending() {

        return Arrays.asList(PENDING_LOST, PENDING_FOUND).contains(this);
    }

    public boolean isLost() {

        return Arrays.asList(PENDING_LOST, ACTIVE_LOST).contains(this);
    }

    public boolean isFound() {

        return Arrays.asList(PENDING_FOUND, ACTIVE_FOUND).contains(this);
    }

    public boolean isSolved() {

        return this == SOLVED;
    }

    public boolean isClosed() {

        return this == CLOSED;
    }
}
