package com.personal.cloud.demo.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.personal.cloud.demo.enums.TypeEnum;

import java.io.IOException;

/**
 * Created by Administrator on 2019-09-17.
 */
public class MySerializerUtils extends JsonSerializer<String> {
    public void serialize(String type, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String typeStr = "" ;
            if( TypeEnum.getEnumByKey(type) != null){
                typeStr = TypeEnum.getEnumByKey(type).getValue();
            }
        jsonGenerator.writeString(typeStr);
    }
}
