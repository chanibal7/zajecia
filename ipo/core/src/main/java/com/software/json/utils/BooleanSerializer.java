/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki           <br/>
 *\*           andrzej.piechocki@software.com *
 *  Created: 2023-12-05
 *
 *****************************************************/

package com.software.json.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class BooleanSerializer
        extends JsonSerializer<Boolean> {

    @Override
    public void serialize(final Boolean value, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeString(value.toString());
    }
}
