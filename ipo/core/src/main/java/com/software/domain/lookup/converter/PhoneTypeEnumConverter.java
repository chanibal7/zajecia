
package com.software.domain.lookup.converter;

import com.software.domain.lookup.PhoneTypeEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PhoneTypeEnumConverter implements AttributeConverter<PhoneTypeEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PhoneTypeEnum enumWithId) {
        return enumWithId.getId();
    }

    @Override
    public PhoneTypeEnum convertToEntityAttribute(Integer id) {
        return PhoneTypeEnum.getEnum(id);
    }
}
