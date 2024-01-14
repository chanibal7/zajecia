
package com.software.domain.lookup;

public enum PhoneTypeEnum implements EnumWithId {

    MOBILE(1),
    ALTERNATIVE_MOBILE(2),
    INTERNATIONAL_MOBILE(3),
    SATELITE_PHONE(4);

    private final int id;

    PhoneTypeEnum(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public static PhoneTypeEnum getEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (PhoneTypeEnum i : PhoneTypeEnum.values()) {
            if (i.getId() == id) {
                return i;
            }
        }
        throw new IllegalArgumentException("No matching type for id " + id);
    }
}
