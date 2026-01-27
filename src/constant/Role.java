package constant;

public enum Role {
    LEADER(1),
    SEMI_LEADER(2),
    NORMAL(3);

    private final int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Role fromCode(int code) {
        for (Role role : values()) {
            if (role.value == code) return role;
        }
        throw new IllegalArgumentException("Role not valid..: " + code);
    }
}
