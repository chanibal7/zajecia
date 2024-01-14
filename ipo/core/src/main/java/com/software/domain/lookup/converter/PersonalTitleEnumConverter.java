package com.software.domain.lookup.converter;

import com.software.domain.lookup.PersonalTitleEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class PersonalTitleEnumConverter implements AttributeConverter<PersonalTitleEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PersonalTitleEnum enumWithId) {
        return enumWithId.getId();
    }

    @Override
    public PersonalTitleEnum convertToEntityAttribute(Integer id) {
        return PersonalTitleEnum.getEnum(id);
    }
}