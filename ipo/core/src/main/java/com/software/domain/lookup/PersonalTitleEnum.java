package com.software.domain.lookup;

public enum PersonalTitleEnum implements EnumWithId {
    MR(1),
    MISS(2);

    private final int id;

    PersonalTitleEnum(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }


    public static PersonalTitleEnum getEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (PersonalTitleEnum personalTitleEnum : PersonalTitleEnum.values()) {
            if (personalTitleEnum.getId() == id) {
                return personalTitleEnum;
            }
        }
        throw new IllegalArgumentException("No matching type for id " + id);
    }
}
