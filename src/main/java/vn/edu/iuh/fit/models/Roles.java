package vn.edu.iuh.fit.models;

import lombok.Getter;

@Getter
public enum Roles {
    ADMINISTRATION(1),
    STAFF(2),
    MANAGER(3),
    EXECUTIVE(4);

    private int value;
    Roles(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
