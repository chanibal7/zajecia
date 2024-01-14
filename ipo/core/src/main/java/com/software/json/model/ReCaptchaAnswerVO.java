/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-12-05
 *
 *****************************************************/
package com.software.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.software.json.utils.BooleanDeserializer;
import com.software.json.utils.BooleanSerializer;

public class ReCaptchaAnswerVO {

    @JsonSerialize(using = BooleanSerializer.class)
    @JsonDeserialize(using = BooleanDeserializer.class)
    private Boolean  success;
    @JsonProperty("error-codes")
    private String[] errorCodes;

    public ReCaptchaAnswerVO() {
    }

    public String[] getErrorCodes() {
        return this.errorCodes;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setErrorCodes(final String[] errorCodesA) {
        this.errorCodes = errorCodesA;
    }

    public void setSuccess(final Boolean successA) {
        this.success = successA;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SUCCESS: ").append(this.getSuccess());
        sb.append(" ERROR CODES: [");
        if ((this.errorCodes != null) && (this.errorCodes.length > 0)) {
            for (final String errorCode : this.errorCodes) {
                sb.append(errorCode).append(";");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
